package com.phantom.model.dao.impl;

import com.phantom.model.dao.DealReviewDao;
import com.phantom.model.entity.DealReview;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class DealReviewDaoImpl  extends GenericHibernateDAO<DealReview, Long> implements DealReviewDao {
    @Override
    public void saveReview(DealReview dealReview) {
        try {
            super.saveOrUpdate(dealReview);
        } catch (Exception e) {
            logger.error("Exception came while saving object", e);
        }
    }
}
