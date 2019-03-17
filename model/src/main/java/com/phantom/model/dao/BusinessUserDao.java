package com.phantom.model.dao;

import com.phantom.model.entity.BusinessUser;

public interface BusinessUserDao extends GenericDAO<BusinessUser, Long> {
    public BusinessUser getBusinessUserDetailsBySSOToken(String ssoToken);

    public BusinessUser getBusinessUserDetailsByUserName(String userName);
}
