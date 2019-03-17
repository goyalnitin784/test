package com.phantom.user.service;

import com.phantom.logging.PhantomLogger;
import com.phantom.model.dao.UserDao;
import com.phantom.model.entity.User;
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

    public void setCookie(HttpServletResponse response, String userName, String ssoToken) {
            requestUtils.addCookie(response, "userName", userName);
            requestUtils.addCookie(response, "ssoToken", ssoToken);
    }

    public User getUserDetails(String id) {
        Long userId = Long.parseLong(id);
        User user = userDao.findById(userId);
        return user;
    }

    public String isValidUser(String userName, String password) {
        if (!StringUtils.isEmpty(userName) && !StringUtils.isEmpty(password)) {
            User user = userDao.getUserDetailsByUserName(userName);
            if (password.equals(user.getPassword())) { // password matches
                String ssoToken = UUID.randomUUID().toString();
                user.setSsoToken(ssoToken);
                userDao.saveOrUpdate(user);
                return ssoToken;
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
            user.setSsoToken(userBean.getSsoToken());
            if (!StringUtils.isEmpty(userBean.getDob())) {
                LocalDate birthDate = LocalDate.parse(userBean.getDob());
                int age = Period.between(birthDate, LocalDate.now()).getYears();
                if (age >= 21) {
                    user.setIsAgeAbove21(1);
                }
            }
            userDao.saveUser(user);

        } catch (Exception e) {
            logger.error("Exception occured while inserting user details for registeration ", e);
        }
    }

}
