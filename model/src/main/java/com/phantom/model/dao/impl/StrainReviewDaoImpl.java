package com.phantom.model.dao.impl;

import com.phantom.model.dao.StrainReviewDao;
import com.phantom.model.entity.DispensaryReview;
import com.phantom.model.entity.StrainReview;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class StrainReviewDaoImpl  extends GenericHibernateDAO<StrainReview, Long> implements StrainReviewDao {


    @Override
    public List<StrainReview> getReviewsByUserId(int userId) {
        try {
            DetachedCriteria criteria = DetachedCriteria.forClass(StrainReview.class);
            criteria.add(Restrictions.eq("reviewerUserId", userId));
            return findByCriteria(criteria);
        }catch (Exception e){
            logger.error("Exception occurred while getting strain review for user id : "+userId, e);
            return null;
        }
    }

    @Override
    public boolean makeReviewPrivate(String uuid) {
        try {
            Query updateQuery = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("update StrainReview set makeReviewPrivate = 1 where uuid = :uuid")
                    .setParameter("uuid", uuid);
            int noOfUpdatedRows = updateQuery.executeUpdate();
            if (noOfUpdatedRows > 0) {
                return true;
            }
        } catch (Exception e) {
            logger.error("Exception came while making strain review private : ", e);
        }
        return false;
    }
}
