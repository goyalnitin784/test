package com.phantom.model.dao.impl;

import com.phantom.model.dao.DispensaryPickUpOrderDao;
import com.phantom.model.entity.DispensaryPickUpOrder;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class DispensaryPickUpOrderDaoImpl extends GenericHibernateDAO<DispensaryPickUpOrder, Long> implements DispensaryPickUpOrderDao {
    @Override
    public void savePickUpOrder(DispensaryPickUpOrder dispensaryPickUpOrder) {
        try {
            super.saveOrUpdate(dispensaryPickUpOrder);
        } catch (Exception e) {
            logger.error("Exception came while saving object", e);
        }
    }

    @Override
    public String getStatus(Long id) {
        DispensaryPickUpOrder dispensaryPickUpOrder = findById(id);
        return dispensaryPickUpOrder.getPickUpOrderStatus();
    }

    @Override
    public List<DispensaryPickUpOrder> getOrdersByDispId(int dispId) {
        DetachedCriteria criteria = DetachedCriteria.forClass(DispensaryPickUpOrder.class);
        criteria.add(Restrictions.eq("dispensaryId", dispId));
        criteria.addOrder(Order.desc("createdOn"));
        return findByCriteria(criteria);
    }

    @Override
    public List<DispensaryPickUpOrder> getOrdersByUserId(int userId) {
        DetachedCriteria criteria = DetachedCriteria.forClass(DispensaryPickUpOrder.class);
        criteria.add(Restrictions.eq("userId", userId));
        criteria.addOrder(Order.desc("createdOn"));
        return findByCriteria(criteria);
    }
}
