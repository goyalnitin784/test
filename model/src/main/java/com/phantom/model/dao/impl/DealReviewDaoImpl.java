package com.phantom.model.dao.impl;

import com.phantom.model.dao.DealReviewDao;
import com.phantom.model.entity.DealReview;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class DealReviewDaoImpl extends GenericHibernateDAO<DealReview, Long> implements DealReviewDao {
    @Override
    public void saveReview(DealReview dealReview) {
        try {
            super.saveOrUpdate(dealReview);
        } catch (Exception e) {
            logger.error("Exception came while saving object", e);
        }
    }

    @Override
    public boolean updateRecommendCount(String uuid) {
        try {
            Query updateQuery = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("update DealReview set recommendationCount = recommendationCount+1 where uuid = :uuid")
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
            Query updateQuery = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("update DealReview set isReviewHelpfulCount = isReviewHelpfulCount+1 where uuid = :uuid")
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
            Query updateQuery = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("update DealReview set sharesCount = sharesCount+1 where uuid = :uuid")
                    .setParameter("uuid", uuid);
            int noOfUpdatedRows = updateQuery.executeUpdate();
            if (noOfUpdatedRows > 0) {
                return true;
            }
        } catch (Exception e) {
            logger.error("Exception came while updating deal review share count : ", e);
        }
        return false;
    }

    @Override
    public boolean makeDealReviewPrivate(String uuid) {
        try {
            Query updateQuery = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("update DealReview set makeReviewPrivate = 1 where uuid = :uuid")
                    .setParameter("uuid", uuid);
            int noOfUpdatedRows = updateQuery.executeUpdate();
            if (noOfUpdatedRows > 0) {
                return true;
            }
        } catch (Exception e) {
            logger.error("Exception came while making deal review private : ", e);
        }
        return false;
    }

    @Override
    public boolean makeDealReviewPublic(String uuid) {
        try {
            Query updateQuery = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("update DealReview set makeReviewPrivate = 0 where uuid = :uuid")
                    .setParameter("uuid", uuid);
            int noOfUpdatedRows = updateQuery.executeUpdate();
            if (noOfUpdatedRows > 0) {
                return true;
            }
        } catch (Exception e) {
            logger.error("Exception came while making deal review public : ", e);
        }
        return false;
    }

    @Override
    public boolean followDealReview(String uuid) {
        try {
            Query updateQuery = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("update DealReview set followers = followers + 1 where uuid = :uuid")
                    .setParameter("uuid", uuid);
            int noOfUpdatedRows = updateQuery.executeUpdate();
            if (noOfUpdatedRows > 0) {
                return true;
            }
        } catch (Exception e) {
            logger.error("Exception came while updating deal review followers count : ", e);
        }
        return false;
    }

    @Override
    public boolean recommendForFuture(String uuid) {
        try {
            Query updateQuery = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("update DealReview set recommendForFuture = recommendForFuture + 1 where uuid = :uuid")
                    .setParameter("uuid", uuid);
            int noOfUpdatedRows = updateQuery.executeUpdate();
            if (noOfUpdatedRows > 0) {
                return true;
            }
        } catch (Exception e) {
            logger.error("Exception came while updating recommendForFuture count : ", e);
        }
        return false;
    }

    @Override
    public List<DealReview> getReviewsByUserId(int userId) {
        try {
            DetachedCriteria criteria = DetachedCriteria.forClass(DealReview.class);
            criteria.add(Restrictions.eq("reviewerUserId", userId));
            return findByCriteria(criteria);
        }catch (Exception e){
            logger.error("Exception occurred while getting deal review for user id : "+userId, e);
            return null;
        }
    }

    @Override
    public List<DealReview> getReviewsByDealId(String dealId) {
        try {
            DetachedCriteria criteria = DetachedCriteria.forClass(DealReview.class);
            criteria.add(Restrictions.eq("dealId", dealId));
            return findByCriteria(criteria);
        }catch (Exception e){
            logger.error("Exception occurred while getting deal review for deal id : "+dealId, e);
            return null;
        }
    }
}
