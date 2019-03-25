package com.phantom.model.dao;

import com.phantom.model.entity.DealReview;

public interface DealReviewDao extends GenericDAO<DealReview, Long> {
    void saveReview(DealReview dealReview);

    boolean updateRecommendCount(String uuid);

    boolean updateReviewHelpfulCount(String uuid);

    boolean updateShareCount(String uuid);

    boolean makeDealReviewPrivate(String uuid);

    boolean makeDealReviewPublic(String uuid);

    boolean followDealReview(String uuid);

    boolean recommendForFuture(String uuid);
}
