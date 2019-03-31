package com.phantom.model.dao.impl;

import com.phantom.model.dao.DispensaryGalleryDao;
import com.phantom.model.entity.DispensaryGallery;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class DispensaryGalleryDaoImpl extends GenericHibernateDAO<DispensaryGallery, Long> implements DispensaryGalleryDao {
    @Override
    public void saveGallery(DispensaryGallery dispensaryGallery) {
        try {
            super.saveOrUpdate(dispensaryGallery);
        } catch (Exception e) {
            logger.error("Exception came while saving object", e);
        }
    }

    @Override
    public List<DispensaryGallery> getDispGalleryByDispId(int dispId) {
        DetachedCriteria criteria = DetachedCriteria.forClass(DispensaryGallery.class);
        criteria.add(Restrictions.eq("dispensaryId",dispId));
        criteria.addOrder(Order.desc("createdOn"));
        return findByCriteria(criteria);
    }

    @Override
    public boolean deleteDispGallery(String uuid) {
        Query updateQuery = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("delete DispensaryGallery where uuid = :uuid")
                .setParameter("uuid", uuid);
        int noOfUpdatedRows = updateQuery.executeUpdate();
        if (noOfUpdatedRows > 0) {
            return true;
        }
        return false;
    }
}
