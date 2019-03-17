package com.phantom.model.dao.impl;

import com.phantom.model.dao.UserDao;
import com.phantom.model.entity.User;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class UserDaoImpl extends GenericHibernateDAO<User, Long> implements UserDao {
    @Override
    public User getUserDetailsBySSOToken(String ssoToken) {
        DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
        criteria.add(Restrictions.eq("ssoToken", ssoToken));
        criteria.addOrder(Order.desc("createdOn"));
        User user = findByCriteria(criteria).get(0);
        return user;
    }

    @Override
    public User getUserDetailsByUserName(String userName) {
        DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
        criteria.add(Restrictions.eq("userName", userName));
        criteria.addOrder(Order.desc("createdOn"));
        User user = findByCriteria(criteria).get(0);
        return user;
    }
}
