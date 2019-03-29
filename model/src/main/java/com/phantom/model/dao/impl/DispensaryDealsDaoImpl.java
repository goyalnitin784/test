package com.phantom.model.dao.impl;

import com.phantom.model.dao.DispensaryDealsDao;
import com.phantom.model.entity.DispensaryDeals;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class DispensaryDealsDaoImpl extends GenericHibernateDAO<DispensaryDeals, Long> implements DispensaryDealsDao {
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
        return isTrendingDeal;
    }

    @Override
    public int isFeaturedDespDeal(String uuid) {
        Query featuredQuery = getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery("select isFeaturedDeal from DispensaryDeals where uuid = :uuid")
                .setParameter("uuid", uuid);
        int isFeaturedDeal = (int) featuredQuery.getSingleResult();
        return isFeaturedDeal;
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

    @Override
    public List<DispensaryDeals> findDealsNearYou(String lat, String longitude, String distance, int maxCount,
                                                  boolean isFeaturedDeal, List<String> dispIdList) {

        if (dispIdList != null && dispIdList.size() > 0) {
            DetachedCriteria criteria = DetachedCriteria.forClass(DispensaryDeals.class);
            criteria.add(Restrictions.in("dispensaryId", dispIdList));
            if (isFeaturedDeal) {
                criteria.add(Restrictions.eq("isFeaturedDeal", 1));
            }
            List<DispensaryDeals> deals = findByCriteria(criteria);
            return deals;
        }
        return null;
    }
}
