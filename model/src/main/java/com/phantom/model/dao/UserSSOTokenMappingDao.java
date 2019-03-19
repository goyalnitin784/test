package com.phantom.model.dao;

import com.phantom.model.entity.UserSSOTokenMapping;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserSSOTokenMappingDao extends GenericDAO<UserSSOTokenMapping, Long>{

    public UserSSOTokenMapping getUserDetailsBySSOToken(String ssoToken);
    void saveSSOToken(UserSSOTokenMapping userSSOTokenMapping);
}
