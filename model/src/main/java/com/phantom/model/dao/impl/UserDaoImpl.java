package com.phantom.model.dao.impl;

import com.phantom.model.dao.UserDao;
import com.phantom.model.entity.User;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;


@Transactional
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
        try {
            DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
            criteria.add(Restrictions.eq("userName", userName));
            criteria.addOrder(Order.desc("createdOn"));
            User user = findByCriteria(criteria).get(0);
            return user;
        }catch (Exception e){
            logger.error("Exception occurred while getting user details for user name :"+userName, e);
            return null;
        }
    }

    @Override
    public User getUserDetailsByEmail(String email) {
        try {
            DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
            criteria.add(Restrictions.eq("email", email));
            criteria.addOrder(Order.desc("createdOn"));
            User user = findByCriteria(criteria).get(0);
            return user;
        }catch (Exception e){
            logger.error("Exception occurred while getting user details for email :"+email, e);
            return null;
        }
    }

    public void saveUser(User user) {
        try{
            super.saveOrUpdate(user);
        }catch (Exception e){
            logger.error("Exception came while saving object",e);
        }

    }
}
