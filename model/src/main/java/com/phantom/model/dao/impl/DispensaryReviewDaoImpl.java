package com.phantom.model.dao.impl;

import com.phantom.model.dao.DispensaryReviewDao;
import com.phantom.model.entity.DispensaryReview;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class DispensaryReviewDaoImpl extends GenericHibernateDAO<DispensaryReview, Long> implements DispensaryReviewDao {
    @Override
    public void saveReview(DispensaryReview dispensaryReview) {
        try {
            super.saveOrUpdate(dispensaryReview);
        } catch (Exception e) {
            logger.error("Exception came while saving object", e);
        }
    }

    @Override
    public boolean updateRecommendCount(String uuid) {
        try {
            Query updateQuery = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("update DispensaryReview set recommendationCount = recommendationCount+1 where uuid = :uuid")
                    .setParameter("uuid", uuid);
            int noOfUpdatedRows = updateQuery.executeUpdate();
            if (noOfUpdatedRows > 0) {
                return true;
            }
        } catch (Exception e) {
            logger.error("Exception came while updating recommendation count : ", e);
        }
        return false;
    }

    @Override
    public boolean updateReviewHelpfulCount(String uuid) {
        try {
            Query updateQuery = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("update DispensaryReview set isReviewHelpfulCount = isReviewHelpfulCount+1 where uuid = :uuid")
                    .setParameter("uuid", uuid);
            int noOfUpdatedRows = updateQuery.executeUpdate();
            if (noOfUpdatedRows > 0) {
                return true;
            }
        } catch (Exception e) {
            logger.error("Exception came while updating isReviewHelpfulCount count : ", e);
        }
        return false;
    }

    @Override
    public boolean updateShareCount(String uuid) {
        try {
            Query updateQuery = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("update DispensaryReview set sharesCount = sharesCount+1 where uuid = :uuid")
                    .setParameter("uuid", uuid);
            int noOfUpdatedRows = updateQuery.executeUpdate();
            if (noOfUpdatedRows > 0) {
                return true;
            }
        } catch (Exception e) {
            logger.error("Exception came while updating dispensary review share count : ", e);
        }
        return false;
    }

    @Override
    public boolean makeDispReviewPrivate(String uuid) {
        try {
            Query updateQuery = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("update DispensaryReview set makeReviewPrivate = 1 where uuid = :uuid")
                    .setParameter("uuid", uuid);
            int noOfUpdatedRows = updateQuery.executeUpdate();
            if (noOfUpdatedRows > 0) {
                return true;
            }
        } catch (Exception e) {
            logger.error("Exception came while making dispensary review private : ", e);
        }
        return false;
    }

    @Override
    public boolean makeDispReviewPublic(String uuid) {
        try {
            Query updateQuery = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("update DispensaryReview set makeReviewPrivate = 0 where uuid = :uuid")
                    .setParameter("uuid", uuid);
            int noOfUpdatedRows = updateQuery.executeUpdate();
            if (noOfUpdatedRows > 0) {
                return true;
            }
        } catch (Exception e) {
            logger.error("Exception came while making dispensary review private : ", e);
        }
        return false;
    }

    @Override
    public boolean followDispReview(String uuid) {
        try {
            Query updateQuery = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("update DispensaryReview set followers = followers + 1 where uuid = :uuid")
                    .setParameter("uuid", uuid);
            int noOfUpdatedRows = updateQuery.executeUpdate();
            if (noOfUpdatedRows > 0) {
                return true;
            }
        } catch (Exception e) {
            logger.error("Exception came while updating dispensary review followers count : ", e);
        }
        return false;
    }

    @Override
    public List<DispensaryReview> getReviewsByUserId(int userId) {
        DetachedCriteria criteria = DetachedCriteria.forClass(DispensaryReview.class);
        criteria.add(Restrictions.eq("reviewerUserId", userId));
        criteria.addOrder(Order.desc("createdOn"));
        return findByCriteria(criteria);
    }

    @Override
    public List<DispensaryReview> getReviewsByDispId(int dispId) {
        DetachedCriteria criteria = DetachedCriteria.forClass(DispensaryReview.class);
        criteria.add(Restrictions.eq("dispensaryId", dispId));
        criteria.addOrder(Order.desc("createdOn"));
        return findByCriteria(criteria);
    }
}
