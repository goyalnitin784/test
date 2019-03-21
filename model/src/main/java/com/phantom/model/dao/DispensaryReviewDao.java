package com.phantom.model.dao;

import com.phantom.model.entity.DispensaryReview;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface DispensaryReviewDao extends GenericDAO<DispensaryReview, Long> {
    void saveReview(DispensaryReview dispensaryReview);
}
