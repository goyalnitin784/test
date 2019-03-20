package com.phantom.model.dao;

import com.phantom.model.entity.BusinessUserSSOTokenMapping;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BusinessUserSSOTokenMappingDao extends GenericDAO<BusinessUserSSOTokenMapping, Long> {

    public BusinessUserSSOTokenMapping getBusinessUserDetailsBySSOToken(String ssoToken);

    void saveSSOToken(BusinessUserSSOTokenMapping businessUserSSOTokenMapping);
}
