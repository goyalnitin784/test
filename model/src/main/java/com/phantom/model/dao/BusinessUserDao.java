package com.phantom.model.dao;

import com.phantom.model.entity.BusinessUser;
import com.phantom.model.entity.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BusinessUserDao extends GenericDAO<BusinessUser, Long> {
    public BusinessUser getBusinessUserDetailsBySSOToken(String ssoToken);

    BusinessUser getBusinessUserDetailsByUserName(String userName);

    void saveBusinessUser(BusinessUser businessUser);

    BusinessUser getBusinessUserDetailsByEmail(String email);

}
