package com.phantom.model.dao;

import com.phantom.model.entity.User;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserDao extends GenericDAO<User, Long> {
    User getUserDetailsBySSOToken(String ssoToken);

    User getUserDetailsByUserName(String userName);

    User getUserDetailsByEmail(String email);

    void saveUser(User user);
}
