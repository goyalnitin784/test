package com.phantom.model.dao;

import com.phantom.model.entity.DispensaryReview;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface DispensaryReviewDao extends GenericDAO<DispensaryReview, Long> {
    void saveReview(DispensaryReview dispensaryReview);

    boolean updateRecommendCount(String uuid);

    boolean updateReviewHelpfulCount(String uuid);

    boolean updateShareCount(String uuid);

    boolean makeDispReviewPrivate(String uuid);

    boolean makeDispReviewPublic(String uuid);

    boolean followDispReview(String uuid);

    List<DispensaryReview> getReviewsByUserId(int userId);
}
