package com.phantom.model.dao.impl;

import com.phantom.model.dao.DispensaryReviewDao;
import com.phantom.model.entity.DispensaryReview;
import org.springframework.transaction.annotation.Transactional;

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
}
