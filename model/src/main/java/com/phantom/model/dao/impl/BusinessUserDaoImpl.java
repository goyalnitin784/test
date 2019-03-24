package com.phantom.model.dao.impl;

import com.phantom.model.dao.BusinessUserDao;
import com.phantom.model.entity.BusinessUser;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class BusinessUserDaoImpl extends GenericHibernateDAO<BusinessUser, Long> implements BusinessUserDao {
    @Override
    public BusinessUser getBusinessUserDetailsBySSOToken(String ssoToken) {
        DetachedCriteria criteria = DetachedCriteria.forClass(BusinessUser.class);
        criteria.add(Restrictions.eq("ssoToken", ssoToken));
        criteria.addOrder(Order.desc("createdOn"));
        BusinessUser businessUser = findByCriteria(criteria).get(0);
        return businessUser;
    }

    @Override
    public BusinessUser getBusinessUserDetailsByUserName(String userName) {
        DetachedCriteria criteria = DetachedCriteria.forClass(BusinessUser.class);
        criteria.add(Restrictions.eq("userName", userName));
        criteria.addOrder(Order.desc("createdOn"));
        BusinessUser businessUser = findByCriteria(criteria).get(0);
        return businessUser;
    }

    @Override
    public void saveBusinessUser(BusinessUser businessUser) {
        try{
            super.saveOrUpdate(businessUser);
        }catch (Exception e){
            logger.error("Exception came while saving object",e);
        }
    }
}
