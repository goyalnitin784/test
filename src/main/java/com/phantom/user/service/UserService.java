package com.phantom.user.service;

import com.phantom.logging.PhantomLogger;
import com.phantom.model.dao.UserDao;
import com.phantom.model.entity.User;
import com.phantom.user.request.UserBean;
import com.phantom.util.RequestUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.time.Period;

@Service
public class UserService {
    private final static PhantomLogger logger = PhantomLogger.getLoggerObject(UserService.class);

    @Autowired
    private RequestUtils requestUtils;
    @Autowired
    private UserDao userDao;

    public void setCookie(HttpServletResponse response, UserBean userBean) {
        if (userBean.isValidUser()) {
            requestUtils.addCookie(response, "userName", userBean.getUserName());
            requestUtils.addCookie(response, "ssoToken", userBean.getSsoToken());
        }
    }

    public User getUserDetails(String id) {
        Long userId = Long.parseLong(id);
        User user = userDao.findById(userId);
        return user;
    }

    public Boolean isValidUser(String userName, String password) {
        if (!StringUtils.isEmpty(userName) && !StringUtils.isEmpty(password)) {
            DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
            criteria.add(Restrictions.eq("userName", userName));
            criteria.addOrder(Order.desc("createdOn"));
            User user = (User) userDao.findByCriteria(criteria);
            if (password.equals(user.getPassword())) { // password matches
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
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
            user.setAgeAbove21(Boolean.FALSE);
            if (!StringUtils.isEmpty(userBean.getDob())) {
                LocalDate birthDate = LocalDate.parse(userBean.getDob());
                int age = Period.between(birthDate, LocalDate.now()).getYears();
                if (age >= 21) {
                    user.setAgeAbove21(Boolean.TRUE);
                }
            }
            userDao.saveOrUpdate(user);

        } catch (Exception e) {
            logger.error("Exception occured while inserting user details for registeration ", e);
        }
    }

}
