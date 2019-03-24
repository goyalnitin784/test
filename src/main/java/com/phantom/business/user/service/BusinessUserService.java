package com.phantom.business.user.service;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.phantom.business.user.request.BusinessUserBean;
import com.phantom.dto.BaseResponseDTO;
import com.phantom.logging.PhantomLogger;
import com.phantom.model.dao.BusinessUserDao;
import com.phantom.model.dao.BusinessUserSSOTokenMappingDao;
import com.phantom.model.entity.BusinessUser;
import com.phantom.model.entity.BusinessUserSSOTokenMapping;
import com.phantom.util.PhantomUtil;
import com.phantom.util.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;

@Service
public class BusinessUserService {
    private final static PhantomLogger logger = PhantomLogger.getLoggerObject(BusinessUserService.class);
    private final static Gson gson = new Gson();
    @Autowired
    private RequestUtils requestUtils;
    @Autowired
    private BusinessUserDao businessUserDao;
    @Autowired
    private BusinessUserSSOTokenMappingDao businessUserSSOTokenMappingDao;

    public void setCookie(HttpServletResponse response, String userName, String ssoToken) {
        requestUtils.addCookie(response, "userName", userName);
        requestUtils.addCookie(response, "bssoToken", ssoToken);
    }

    public BusinessUser getBusinessUserDetails(String ssoToken) {
        try {
            BusinessUserSSOTokenMapping businessUserSSOTokenMapping = businessUserSSOTokenMappingDao.getBusinessUserDetailsBySSOToken(ssoToken);
            BusinessUser businessUser = businessUserDao.findById(businessUserSSOTokenMapping.getUserId());
            return businessUser;
        }catch (Exception e){
            logger.error("Exception occurred while fetching business user details ");
            return null;
        }
    }

    public String getBusinessUserDetailsAsJson(String ssoToken) {
        String msg = "SUCCESS";
        String code = "200";
        JsonElement response = null;
        try {
            if (PhantomUtil.isNullOrEmpty(ssoToken)) {
                msg = "Business User Not Logged In";
                code = "404";
            }
            BusinessUserSSOTokenMapping businessUserSSOTokenMapping = businessUserSSOTokenMappingDao.getBusinessUserDetailsBySSOToken(ssoToken);
            if (businessUserSSOTokenMapping == null) {
                msg = "Business User Not Logged In";
                code = "404";
            } else {
                response = gson.toJsonTree(businessUserDao.findById(businessUserSSOTokenMapping.getUserId()));
            }
        } catch (Exception e) {
            logger.error("Exception occurred while fetching business user details ",e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        baseResponseDTO.setResponse(response);
        return gson.toJson(baseResponseDTO);
    }

    public BusinessUser isValidUser(String userName, String password) {
        if (!StringUtils.isEmpty(userName) && !StringUtils.isEmpty(password)) {
            BusinessUser businessUser = businessUserDao.getBusinessUserDetailsByUserName(userName);
            if (password.equals(businessUser.getPassword())) { // password matches
                return businessUser;
            }
        }
        return null;
    }

    public String insertUserDetails(BusinessUserBean businessUserBean) {
        String msg = "SUCCESS";
        String code = "200";
        try {
            if (businessUserBean.isValidUser()) {
                BusinessUser businessUser = new BusinessUser();
                businessUser.setUserName(businessUserBean.getUserName());
                businessUser.setPassword(businessUserBean.getPassword());
                businessUser.setDob(businessUserBean.getDob());
                businessUser.setEmail(businessUserBean.getEmail());
                businessUser.setPhoneNo(businessUserBean.getPhoneNo());
                businessUser.setProfilePic(businessUserBean.getProfilePic());
                businessUser.setUserType(businessUserBean.getUserType());
                businessUser.setDob(businessUserBean.getDob());
                businessUser.setSsoToken(businessUserBean.getSsoToken());
                businessUser.setDispensaryId(businessUserBean.getDispensaryId());
                businessUserDao.saveBusinessUser(businessUser);
                businessUserBean.setBusinessUserId(businessUser.getBusinessUserId());
                setSSOToken(businessUserBean.getBusinessUserId(), businessUserBean.getUserName(), businessUserBean.getSsoToken());
            } else {
                msg = "BAD REQUEST";
                code = "404";
            }

        } catch (Exception e) {
            logger.error("Exception occurred while inserting business user details for registration ", e);
            msg = e.getMessage();
            code = "500";
        }
        BaseResponseDTO baseResponseDTO = new BaseResponseDTO();
        baseResponseDTO.setCode(code);
        baseResponseDTO.addMessage(msg);
        return gson.toJson(baseResponseDTO);
    }

    public void setSSOToken(long userId, String userName, String ssoToken) {
        BusinessUserSSOTokenMapping businessUserSSOTokenMapping = new BusinessUserSSOTokenMapping();
        try {
            businessUserSSOTokenMapping.setUserId(userId);
            businessUserSSOTokenMapping.setSsoToken(ssoToken);
            businessUserSSOTokenMapping.setUserName(userName);
            businessUserSSOTokenMapping.setIsActive(1);

            businessUserSSOTokenMappingDao.saveSSOToken(businessUserSSOTokenMapping);
        } catch (Exception e) {
            logger.error("Exception occurred while persisting sso-token for business user : " + userId, e);
        }
    }

    public String logout(String ssoToken) {
        String msg = "SUCCESS";
        String code = "200";
        try {
            if (PhantomUtil.isNullOrEmpty(ssoToken)) {
                msg = "Business User Not Logged In";
                code = "404";
            }
            BusinessUserSSOTokenMapping businessUserSSOTokenMapping = businessUserSSOTokenMappingDao.getBusinessUserDetailsBySSOToken(ssoToken);
            if (businessUserSSOTokenMapping == null) {
                msg = "Business User Not Logged In";
                code = "404";
            }
            businessUserSSOTokenMapping.setIsActive(0);
            businessUserSSOTokenMappingDao.saveSSOToken(businessUserSSOTokenMapping);
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

    public int getBusinessUserId(String bssoToken) {
        if (!PhantomUtil.isNullOrEmpty(bssoToken)) {
            BusinessUserSSOTokenMapping businessUserSSOTokenMapping = businessUserSSOTokenMappingDao.getBusinessUserDetailsBySSOToken(bssoToken);
            if (businessUserSSOTokenMapping != null) {
                return (int) businessUserSSOTokenMapping.getUserId();
            }
        }
        return -1;  // not logged in
    }

}
