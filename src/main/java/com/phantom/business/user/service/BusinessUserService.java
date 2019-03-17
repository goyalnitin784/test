package com.phantom.business.user.service;

import com.phantom.business.user.request.BusinessUserBean;
import com.phantom.logging.PhantomLogger;
import com.phantom.model.dao.BusinessUserDao;
import com.phantom.model.entity.BusinessUser;
import com.phantom.util.RequestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletResponse;

@Service
public class BusinessUserService {
    private final static PhantomLogger logger = PhantomLogger.getLoggerObject(BusinessUserService.class);

    @Autowired
    private RequestUtils requestUtils;
    @Autowired
    private BusinessUserDao businessUserDao;

    public void setCookie(HttpServletResponse response, BusinessUserBean businessUserBean) {
        if (businessUserBean.isValidUser()) {
            requestUtils.addCookie(response, "userName", businessUserBean.getUserName());
            requestUtils.addCookie(response, "ssoToken", businessUserBean.getSsoToken());
        }
    }

    public Boolean isValidUser(String userName, String password) {
        if (!StringUtils.isEmpty(userName) && !StringUtils.isEmpty(password)) {
            BusinessUser businessUser = businessUserDao.getBusinessUserDetailsByUserName(userName);
            if (password.equals(businessUser.getPassword())) { // password matches
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public void insertUserDetails(BusinessUserBean businessUserBean) {
        BusinessUser businessUser = new BusinessUser();
        try {
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
            businessUserDao.saveOrUpdate(businessUser);

        } catch (Exception e) {
            logger.error("Exception occured while inserting business user details for registeration ", e);
        }
    }

}
