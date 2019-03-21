package com.phantom.user.service;

import com.phantom.logging.PhantomLogger;
import com.phantom.model.dao.UserDao;
import com.phantom.model.dao.UserSSOTokenMappingDao;
import com.phantom.model.entity.User;
import com.phantom.model.entity.UserSSOTokenMapping;
import com.phantom.user.request.UserBean;
import com.phantom.util.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.Period;
import java.util.UUID;

@Service
public class UserService {
    private final static PhantomLogger logger = PhantomLogger.getLoggerObject(UserService.class);

    @Autowired
    private RequestUtils requestUtils;
    @Autowired
    private UserDao userDao;
    @Autowired
    private UserSSOTokenMappingDao userSSOTokenMappingDao;

    public void setCookie(HttpServletResponse response, String userName, String ssoToken) {
            requestUtils.addCookie(response, "userName", userName);
            requestUtils.addCookie(response, "ssoToken", ssoToken);
    }

    public User getUserDetails(String ssoToken) {
        try {
            UserSSOTokenMapping userSSOTokenMapping = userSSOTokenMappingDao.getUserDetailsBySSOToken(ssoToken);
            User user = userDao.findById(userSSOTokenMapping.getUserId());
            return user;
        }catch (Exception e){
         logger.error("Exception occurred while fetching user details ",e);
         return null;
        }
    }

    public User isValidUser(String userName, String password) {
        if (!StringUtils.isEmpty(userName) && !StringUtils.isEmpty(password)) {
            User user = userDao.getUserDetailsByUserName(userName);
            if (password.equals(user.getPassword())) { // password matches
                return user;
            }
        }
        return null;
    }

    public void insertUserDetails(UserBean userBean) {
        User user = new User();
        try {
            user.setUserName(userBean.getUserName());
            user.setPassword(userBean.getPassword());
            user.setDob(userBean.getDob());
            user.setEmail(userBean.getEmail());
            user.setPhoneNo(userBean.getPhoneNo());
            user.setProfilePic(userBean.getProfilePic());
            user.setUserType(userBean.getUserType());
            user.setDob(userBean.getDob());
            user.setIsAgeAbove21(0);
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

        } catch (Exception e) {
            logger.error("Exception occured while inserting user details for registeration ", e);
        }
    }

    public void setSSOToken(long userId, String userName, String ssoToken){
        UserSSOTokenMapping userSSOTokenMapping = new UserSSOTokenMapping();
        try{
            userSSOTokenMapping.setUserId(userId);
            userSSOTokenMapping.setSsoToken(ssoToken);
            userSSOTokenMapping.setUserName(userName);
            userSSOTokenMapping.setIsActive(1);
            userSSOTokenMappingDao.saveSSOToken(userSSOTokenMapping);
        }catch (Exception e){
            logger.error("Exception occurred while persisting sso-token for user : "+ userId, e);
        }
    }

}
