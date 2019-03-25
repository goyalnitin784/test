package com.phantom.model.dao.impl;

import com.phantom.model.dao.DispensaryDealsDao;
import com.phantom.model.entity.DispensaryDeals;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DispensaryDealsDaoImpl  extends GenericHibernateDAO<DispensaryDeals, Long> implements DispensaryDealsDao {
    @Override
    public void saveDeals(DispensaryDeals dispensaryDeals) {
        try {
            super.saveOrUpdate(dispensaryDeals);
        } catch (Exception e) {
            logger.error("Exception came while saving object", e);
        }
    }

    @Override
    public int isTrendingDispDeal(String uuid) {
        Query trendingQuery = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("select isTrendingDeal from DispensaryDeals where uuid = :uuid")
                .setParameter("uuid", uuid);
        int isTrendingDeal = (int) trendingQuery.getSingleResult();
        return  isTrendingDeal;
    }

    @Override
    public int isFeaturedDespDeal(String uuid) {
        Query featuredQuery = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("select isFeaturedDeal from DispensaryDeals where uuid = :uuid")
                .setParameter("uuid", uuid);
        int isFeaturedDeal = (int) featuredQuery.getSingleResult();
        return  isFeaturedDeal;
    }

    @Override
    public boolean updateFollowers(String uuid) {
        try {
            Query updateQuery = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("update DispensaryDeals set followers = followers + 1 where uuid = :uuid")
                    .setParameter("uuid", uuid);
            int noOfUpdatedRows = updateQuery.executeUpdate();
            if (noOfUpdatedRows > 0) {
                return true;
            }
        } catch (Exception e) {
            logger.error("Exception came while updating followers count : ", e);
        }
        return false;
    }
}
