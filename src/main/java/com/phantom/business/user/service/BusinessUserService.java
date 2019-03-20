package com.phantom.business.user.service;

import com.phantom.business.user.request.BusinessUserBean;
import com.phantom.logging.PhantomLogger;
import com.phantom.model.dao.BusinessUserDao;
import com.phantom.model.dao.BusinessUserSSOTokenMappingDao;
import com.phantom.model.entity.BusinessUser;
import com.phantom.model.entity.BusinessUserSSOTokenMapping;
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
    @Autowired
    private BusinessUserSSOTokenMappingDao businessUserSSOTokenMappingDao;

    public void setCookie(HttpServletResponse response, String userName, String ssoToken) {
        requestUtils.addCookie(response, "userName", userName);
        requestUtils.addCookie(response, "ssoToken", ssoToken);
    }

    public BusinessUser getBusinessUserDetails(String ssoToken) {
        BusinessUserSSOTokenMapping businessUserSSOTokenMapping = businessUserSSOTokenMappingDao.getBusinessUserDetailsBySSOToken(ssoToken);
        BusinessUser businessUser = businessUserDao.findById(businessUserSSOTokenMapping.getUserId());
        return businessUser;
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
            businessUserBean.setBusinessUserId(businessUser.getBusinessUserId());

        } catch (Exception e) {
            logger.error("Exception occured while inserting business user details for registration ", e);
        }
    }

    public void setSSOToken(long userId, String userName, String ssoToken) {
        BusinessUserSSOTokenMapping businessUserSSOTokenMapping = new BusinessUserSSOTokenMapping();
        try {
            businessUserSSOTokenMapping.setUserId(userId);
            businessUserSSOTokenMapping.setSsoToken(userName);
            businessUserSSOTokenMapping.setUserName(ssoToken);

            businessUserSSOTokenMappingDao.saveSSOToken(businessUserSSOTokenMapping);
        } catch (Exception e) {
            logger.error("Exception occurred while persisting sso-token for business user : " + userId, e);
        }
    }

}
