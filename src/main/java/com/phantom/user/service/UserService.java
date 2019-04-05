package com.phantom.user.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.phantom.dto.BaseResponseDTO;
import com.phantom.logging.PhantomLogger;
import com.phantom.model.dao.DealReviewDao;
import com.phantom.model.dao.UserDao;
import com.phantom.model.dao.UserSSOTokenMappingDao;
import com.phantom.model.entity.DealReview;
import com.phantom.model.entity.User;
import com.phantom.model.entity.UserSSOTokenMapping;
import com.phantom.user.request.DealReviewBean;
import com.phantom.user.request.UserBean;
import com.phantom.util.PhantomUtil;
import com.phantom.util.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.Period;

@Service
public class UserService {
    private final static PhantomLogger logger = PhantomLogger.getLoggerObject(UserService.class);
    private final static Gson gson = new Gson();
    @Autowired
    private RequestUtils requestUtils;
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserSSOTokenMappingDao userSSOTokenMappingDao;
    @Autowired
    private DealReviewDao dealReviewDao;

    public void setCookie(HttpServletResponse response, String userName, String ssoToken) {
        requestUtils.addCookie(response, "userName", userName);
        requestUtils.addCookie(response, "ssoToken", ssoToken);
    }

    public User getUserDetails(String ssoToken) {
        try {
            UserSSOTokenMapping userSSOTokenMapping = userSSOTokenMappingDao.getUserDetailsBySSOToken(ssoToken);
            User user = userDao.findById(userSSOTokenMapping.getUserId());
            return user;
        } catch (Exception e) {
            logger.error("Exception occurred while fetching user details ", e);
            return null;
        }
    }

    public String getUserDetailsAsJson(String ssoToken) {
        String msg = "SUCCESS";
        String code = "200";
        JsonElement response = null;
        try {
            if (PhantomUtil.isNullOrEmpty(ssoToken)) {
                msg = "User Not Logged In";
                code = "400";
            }
            UserSSOTokenMapping userSSOTokenMapping = userSSOTokenMappingDao.getUserDetailsBySSOToken(ssoToken);
            if (userSSOTokenMapping == null) {
                msg = "User Not Logged In";
                code = "400";
            } else {
                response = gson.toJsonTree(userDao.findById(userSSOTokenMapping.getUserId()));
            }
        } catch (Exception e) {
            logger.error("Exception occurred while fetching user details ", e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        baseResponseDTO.setResponse(response);
        return gson.toJson(baseResponseDTO);
    }

    public User isValidUser(String userName, String password, String email) {
        try {
            if (!PhantomUtil.isNullOrEmpty(password)) {
                User user = null;
                if (!PhantomUtil.isNullOrEmpty(userName)) {
                    user = userDao.getUserDetailsByUserName(userName);
                }else{
                    user = userDao.getUserDetailsByEmail(email);
                }
                if (user!=null && password.equals(user.getPassword())) { // password matches and user is above 21
                    return user;
                }
            }
        } catch (Exception e) {
            logger.error("Exception occurred while login user with username : " + userName + " or email " + email, e);
        }
        return null;
    }

    public String insertUserDetails(UserBean userBean) {
        String msg = "Successfully Registered";
        String code = "200";
        try {
            if (isUserAlreadyExist(userBean.getEmail())) {
                msg = "emailAddressAlreadyExists";
            } else if (userBean.isValidUser()) {
                User user = new User();
                user.setUserName(userBean.getUserName());
                user.setPassword(userBean.getPassword());
                user.setDob(userBean.getDob());
                user.setEmail(userBean.getEmail());
                user.setPhoneNo(userBean.getPhoneNo());
                user.setProfilePicId(userBean.getPicId());
                user.setUserType(userBean.getUserType());
                user.setDob(userBean.getDob());
                user.setIsAgeAbove21(0);
                user.setTermConditionFlag(userBean.getIsAgreeToTC());
                if (!StringUtils.isEmpty(userBean.getDob())) {
                    LocalDate birthDate = LocalDate.parse(userBean.getDob());
                    int age = Period.between(birthDate, LocalDate.now()).getYears();
                    if (age >= 21) {
                        user.setIsAgeAbove21(1);
                    }
                }
                user.setSsoToken(userBean.getSsoToken());
                userDao.saveUser(user);
                userBean.setUserId(user.getUserId());
                setSSOToken(userBean.getUserId(), userBean.getUserName(), userBean.getSsoToken());
            } else {
                msg = "BAD REQUEST";
                code = "400";
            }

        } catch (Exception e) {
            logger.error("Exception occured while inserting user details for registeration ", e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        return gson.toJson(baseResponseDTO);
    }

    public void setSSOToken(long userId, String userName, String ssoToken) {
        UserSSOTokenMapping userSSOTokenMapping = new UserSSOTokenMapping();
        try {
            userSSOTokenMapping.setUserId(userId);
            userSSOTokenMapping.setSsoToken(ssoToken);
            userSSOTokenMapping.setUserName(userName);
            userSSOTokenMapping.setIsActive(1);
            userSSOTokenMappingDao.saveSSOToken(userSSOTokenMapping);
        } catch (Exception e) {
            logger.error("Exception occurred while persisting sso-token for user : " + userId, e);
        }
    }

    public String giveDealReview(DealReviewBean dealReviewBean) {
        String msg = "SUCCESS";
        String code = "200";
        try {
            if (dealReviewBean.getReviewerUserId() == -1) {
                code = "400";
                msg = "User Not Logged In";
            } else if (dealReviewBean.isValidReview()) {
                DealReview dealReview = new DealReview();
                dealReview.setReviewerUserId(dealReview.getReviewerUserId());
                dealReview.setDispensaryId(dealReviewBean.getDispensaryId());
                dealReview.setRecommendationCount(dealReviewBean.getRecommendationCount());
                dealReview.setIsReviewHelpfulCount(dealReviewBean.getIsReviewHelpfulCount());
                dealReview.setSharesCount(dealReviewBean.getSharesCount());
                dealReview.setMakeReviewPrivate(dealReviewBean.getMakeReviewPrivate());
                dealReview.setIsActive(dealReviewBean.getIsActive());
                dealReview.setReviewDesc(dealReviewBean.getReviewDesc());
                dealReview.setFollowers(dealReviewBean.getFollowers());
                dealReview.setOverAllRating(dealReviewBean.getOverAllRating());
                dealReview.setValueForMoneyRating(dealReviewBean.getValueForMoneyRating());
                dealReview.setDealCorrectnessRating(dealReviewBean.getDealCorrectnessRating());
                dealReview.setRecommendForFuture(dealReviewBean.getRecommendForFuture());
                dealReview.setUuid(dealReviewBean.getUuid());

                dealReviewDao.saveReview(dealReview);
            } else {
                code = "400";
                msg = "BAD REQUEST";
            }
        } catch (Exception e) {
            logger.error("Exception occured while giving deal review ", e);
            code = "500";
            msg = e.getMessage();
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        return gson.toJson(baseResponseDTO);
    }

    public String logout(String ssoToken) {
        String msg = "User Successfully Logged Out";
        String code = "200";
        try {
            if (PhantomUtil.isNullOrEmpty(ssoToken)) {
                msg = "User Not Logged In";
                code = "400";
            }
            UserSSOTokenMapping userSSOTokenMapping = userSSOTokenMappingDao.getUserDetailsBySSOToken(ssoToken);
            if (userSSOTokenMapping == null) {
                msg = "User Not Logged In";
                code = "400";
            }
            else {
                userSSOTokenMapping.setIsActive(0);
                userSSOTokenMappingDao.saveSSOToken(userSSOTokenMapping);
            }
        } catch (Exception e) {
            logger.error("Exception occurred while logging out user ", e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        return gson.toJson(baseResponseDTO);
    }

    public int getUserId(String ssoToken) {
        if (!PhantomUtil.isNullOrEmpty(ssoToken)) {
            UserSSOTokenMapping userSSOTokenMapping = userSSOTokenMappingDao.getUserDetailsBySSOToken(ssoToken);
            if (userSSOTokenMapping != null) {
                return (int) userSSOTokenMapping.getUserId();
            }
        }
        return -1;  // not logged in
    }

    public String getAboutMe(String ssoToken) {
        String msg = "SUCCESS";
        String code = "200";
        JsonElement response = null;
        try {
            if (PhantomUtil.isNullOrEmpty(ssoToken)) {
                msg = "User Not Logged In";
                code = "400";
            } else {
                User user = getUserDetails(ssoToken);
                if (user == null) {
                    msg = "User Not Logged In";
                    code = "400";
                } else {
                    JsonObject userJson = new JsonObject();
                    userJson.addProperty("profilePic", user.getProfilePicId());
                    userJson.addProperty("aboutMe", user.getAboutMe());
                    userJson.addProperty("experience", user.getExperience());
                    response = userJson;
                }
            }
        } catch (Exception e) {
            logger.error("Exception occurred while fetching getAboutMe ", e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.addMessage(msg);
        baseResponseDTO.setCode(code);
        baseResponseDTO.setResponse(response);
        return gson.toJson(baseResponseDTO);
    }

    public String addAboutMe(String ssoToken, String aboutMe) {
        String msg = "SUCCESS";
        String code = "200";
        try {
            if (PhantomUtil.isNullOrEmpty(ssoToken) || PhantomUtil.isNullOrEmpty(aboutMe)) {
                msg = PhantomUtil.isNullOrEmpty(ssoToken) ? "User Not Logged In" : "BAD REQUEST";
                code = "400";
            } else {
                User user = getUserDetails(ssoToken);
                if (user == null) {
                    msg = "User Not Logged In";
                    code = "400";
                } else {
                    user.setAboutMe(aboutMe);
                    userDao.saveUser(user);
                }
            }
        } catch (Exception e) {
            logger.error("Exception occurred while updating AboutMe ", e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.addMessage(msg);
        baseResponseDTO.setCode(code);
        return gson.toJson(baseResponseDTO);
    }

    public String addExperience(String ssoToken, String experience) {
        String msg = "SUCCESS";
        String code = "200";
        try {
            if (PhantomUtil.isNullOrEmpty(ssoToken) || PhantomUtil.isNullOrEmpty(experience)) {
                msg = PhantomUtil.isNullOrEmpty(ssoToken) ? "User Not Logged In" : "BAD REQUEST";
                code = "400";
            } else {
                User user = getUserDetails(ssoToken);
                if (user == null) {
                    msg = "User Not Logged In";
                    code = "400";
                } else {
                    user.setExperience(experience);
                    userDao.saveUser(user);
                }
            }
        } catch (Exception e) {
            logger.error("Exception occurred while updating experience ", e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.addMessage(msg);
        baseResponseDTO.setCode(code);
        return gson.toJson(baseResponseDTO);
    }

    public String addProfilePic(String ssoToken, String picPath) {
        String msg = "SUCCESS";
        String code = "200";
        try {
            if (PhantomUtil.isNullOrEmpty(ssoToken) || PhantomUtil.isNullOrEmpty(picPath)) {
                msg = PhantomUtil.isNullOrEmpty(ssoToken) ? "User Not Logged In" : "BAD REQUEST";
                code = "400";
            } else {
                User user = getUserDetails(ssoToken);
                if (user == null) {
                    msg = "User Not Logged In";
                    code = "400";
                } else {
                    user.setProfilePicId(picPath);
                    userDao.saveUser(user);
                }
            }
        } catch (Exception e) {
            logger.error("Exception occurred while updating profile pic path ", e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.addMessage(msg);
        baseResponseDTO.setCode(code);
        return gson.toJson(baseResponseDTO);
    }

    public String getListofMypics(String ssoToken) {
        String msg = "SUCCESS";
        String code = "200";
        JsonElement response = null;
        try {
            if (PhantomUtil.isNullOrEmpty(ssoToken)) {
                msg = "User Not Logged In";
                code = "400";
            } else {
                User user = getUserDetails(ssoToken);
                if (user == null) {
                    msg = "User Not Logged In";
                    code = "400";
                } else {
                    response = gson.toJsonTree(user.getProfilePicId());
                }
            }
        } catch (Exception e) {
            logger.error("Exception occurred while getting profile pics", e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.addMessage(msg);
        baseResponseDTO.setCode(code);
        baseResponseDTO.setResponse(response);
        return gson.toJson(baseResponseDTO);
    }

    public boolean isUserAlreadyExist(String email) {
        try {
            return userDao.getUserDetailsByEmail(email) != null ? Boolean.TRUE : Boolean.FALSE;
        } catch (Exception e) {
            return Boolean.FALSE;
        }
    }

    public String changePassword(int userId, String newPassword){
        String msg = "Password changed successfully";
        String code = "200";
        JsonElement response = null;
        try{
            if(userId == -1 || PhantomUtil.isNullOrEmpty(newPassword)){
                msg = userId == -1 ? "User Not Logged In" : "BAD REQUEST";
                code = "400";
            }else {
                User user = userDao.findById(new Long(userId));
                if(user != null){
                    user.setPassword(newPassword);
                    userDao.saveUser(user);
                    response = gson.toJsonTree(user);
                }else{
                    msg = "User Not Present";
                    code = "400";
                }
            }
        }catch (Exception e){
            logger.error("Exception occurred while changing password for userId : "+userId, e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setResponse(response);
        baseResponseDTO.addMessage(msg);
        baseResponseDTO.setCode(code);
        return gson.toJson(baseResponseDTO);
    }

    public String changePhoneNo(int userId, String newPhoneNo){
        String msg = "Phone Number Changed Successfully";
        String code = "200";
        JsonElement response = null;
        try{
            if(userId == -1 || PhantomUtil.isNullOrEmpty(newPhoneNo)){
                msg = userId == -1 ? "User Not Logged In" : "BAD REQUEST";
                code = "400";
            }else {
                User user = userDao.findById(new Long(userId));
                if(user != null){
                    user.setPhoneNo(newPhoneNo);
                    userDao.saveUser(user);
                    response = gson.toJsonTree(user);
                }else{
                    msg = "User Not Present";
                    code = "400";
                }
            }
        }catch (Exception e){
            logger.error("Exception occurred while changing password for userId : "+userId, e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setResponse(response);
        baseResponseDTO.addMessage(msg);
        baseResponseDTO.setCode(code);
        return gson.toJson(baseResponseDTO);
    }

    public String forgotPassword(String email, String userName, String newPassword){
        String msg = "Password Changed Successfully";
        String code = "200";
        JsonElement response = null;
        try{
            if((PhantomUtil.isNullOrEmpty(email) && PhantomUtil.isNullOrEmpty(userName)) || PhantomUtil.isNullOrEmpty(newPassword)){
                msg = "BAD REQUEST";
                code = "400";
            }else {
                User user = PhantomUtil.isNullOrEmpty(email) ? userDao.getUserDetailsByUserName(userName) : userDao.getUserDetailsByEmail(email);
                if(user != null){
                    user.setPassword(newPassword);
                    userDao.saveUser(user);
                    response = gson.toJsonTree(user);
                }else{
                    msg = "User Not Present";
                    code = "400";
                }
            }
        }catch (Exception e){
            logger.error("Exception occurred while changing password for user : "+userName +" and email : "+email, e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setResponse(response);
        baseResponseDTO.addMessage(msg);
        baseResponseDTO.setCode(code);
        return gson.toJson(baseResponseDTO);
    }
}
