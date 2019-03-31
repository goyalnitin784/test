package com.phantom.model.dao.impl;

import com.phantom.model.dao.DispensaryUpdatesDao;
import com.phantom.model.entity.DispensaryUpdates;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class DispensaryUpdatesDaoImpl extends GenericHibernateDAO<DispensaryUpdates, Long> implements DispensaryUpdatesDao {
    @Override
    public void saveUpdates(DispensaryUpdates dispensaryUpdates) {
        try {
            super.saveOrUpdate(dispensaryUpdates);
        } catch (Exception e) {
            logger.error("Exception came while saving object", e);
        }
    }

    @Override
    public List<DispensaryUpdates> getUpdatesByDispId(int dispId) {
        DetachedCriteria criteria = DetachedCriteria.forClass(DispensaryUpdates.class);
        criteria.add(Restrictions.eq("dispensaryId", dispId));
        criteria.addOrder(Order.desc("createdOn"));
        return findByCriteria(criteria);
    }

    @Override
    public boolean editDispUpdates(String uuid, String dispUpdates) {
        Query updateQuery = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("update DispensaryUpdates set updateDetails = :dispUpdates where uuid = :uuid")
                .setParameter("updateDetails",dispUpdates)
                .setParameter("uuid", uuid);
        int noOfUpdatedRows = updateQuery.executeUpdate();
        if (noOfUpdatedRows > 0) {
            return true;
        }
        return false;
    }
}
