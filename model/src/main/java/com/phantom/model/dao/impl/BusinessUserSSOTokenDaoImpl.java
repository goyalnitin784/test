package com.phantom.model.dao.impl;

import com.phantom.model.dao.BusinessUserSSOTokenMappingDao;
import com.phantom.model.entity.BusinessUserSSOTokenMapping;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

public class BusinessUserSSOTokenDaoImpl extends GenericHibernateDAO<BusinessUserSSOTokenMapping, Long> implements BusinessUserSSOTokenMappingDao {

    @Override
    public BusinessUserSSOTokenMapping getBusinessUserDetailsBySSOToken(String ssoToken) {
        try {
            DetachedCriteria criteria = DetachedCriteria.forClass(BusinessUserSSOTokenMapping.class);
            criteria.add(Restrictions.eq("ssoToken", ssoToken));
            criteria.add(Restrictions.eq("isActive", 1));
            criteria.addOrder(Order.desc("createdOn"));
            return findByCriteria(criteria).get(0);
        } catch (Exception e) {
            logger.error("Exception occurred while fetching user details by sso token ", e);
            return null;
        }
    }

    @Override
    public void saveSSOToken(BusinessUserSSOTokenMapping entity) {
        try {
            super.saveOrUpdate(entity);
        } catch (Exception e) {
            logger.error("Exception came while saving object", e);
        }
    }
}
