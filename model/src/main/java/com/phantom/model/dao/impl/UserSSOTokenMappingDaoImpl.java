package com.phantom.model.dao.impl;

import com.phantom.model.dao.UserSSOTokenMappingDao;
import com.phantom.model.entity.UserSSOTokenMapping;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class UserSSOTokenMappingDaoImpl extends GenericHibernateDAO<UserSSOTokenMapping, Long> implements UserSSOTokenMappingDao {

    @Override
    public UserSSOTokenMapping getUserDetailsBySSOToken(String ssoToken) {
        try {
            DetachedCriteria criteria = DetachedCriteria.forClass(UserSSOTokenMapping.class);
            criteria.add(Restrictions.eq("ssoToken", ssoToken));
            criteria.add(Restrictions.eq("isActive",1));
            criteria.addOrder(Order.desc("createdOn"));
            return findByCriteria(criteria).get(0);
        } catch (Exception e) {
           logger.error("Exception occurred while fetching user details by sso token ", e);
            return null;
        }
    }

    @Override
    public void saveSSOToken(UserSSOTokenMapping entity) {
        try {
            super.saveOrUpdate(entity);
        } catch (Exception e) {
            logger.error("Exception came while saving object", e);
        }
    }
}
