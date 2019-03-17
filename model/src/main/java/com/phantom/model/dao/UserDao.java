package com.phantom.model.dao;

import com.phantom.model.entity.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserDao extends GenericDAO<User,Long>{
    public User getUserDetailsBySSOToken(String ssoToken);
    public User getUserDetailsByUserName(String userName);
}
