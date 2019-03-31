package com.phantom.model.dao.impl;

import com.phantom.model.dao.DispensaryPickUpOrderDao;
import com.phantom.model.entity.DispensaryPickUpOrder;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
    public String getStatus(String orderId) {
        DetachedCriteria criteria = DetachedCriteria.forClass(DispensaryPickUpOrder.class);
        criteria.add(Restrictions.eq("uuid", orderId));
        return findByCriteria(criteria).get(0).getPickUpOrderStatus();
    }

    @Override
    public boolean updateStatus(String orderId, String pickUpOrderStatus) {
        Query updateQuery = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("update DispensaryPickUpOrder set pickUpOrderStatus = :pickUpOrderStatus where uuid = :uuid")
                .setParameter("pickUpOrderStatus", pickUpOrderStatus)
                .setParameter("uuid", orderId);
        int noOfUpdatedRows = updateQuery.executeUpdate();
        if (noOfUpdatedRows > 0) {
            return true;
        }
        return false;
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

    @Override
    public List<DispensaryPickUpOrder> getOrdersByOrderId(String orderId) {
        DetachedCriteria criteria = DetachedCriteria.forClass(DispensaryPickUpOrder.class);
        criteria.add(Restrictions.eq("uuid", orderId));
        return findByCriteria(criteria);
    }

    @Override
    public boolean updatePickUpDate(String orderId, Date pickUpDate) {
        Query updateQuery = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("update DispensaryPickUpOrder set pickUpDate = :pickUpDate where uuid = :uuid")
                .setParameter("pickUpDate", pickUpDate)
                .setParameter("uuid", orderId);
        int noOfUpdatedRows = updateQuery.executeUpdate();
        if (noOfUpdatedRows > 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateTimeSlot(String orderId, String pickUpTimeSlot) {
        Query updateQuery = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("update DispensaryPickUpOrder set pickUpTimeSlot = :pickUpTimeSlot where uuid = :uuid")
                .setParameter("pickUpTimeSlot", pickUpTimeSlot)
                .setParameter("uuid", orderId);
        int noOfUpdatedRows = updateQuery.executeUpdate();
        if (noOfUpdatedRows > 0) {
            return true;
        }
        return false;
    }
}
