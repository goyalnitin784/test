package com.phantom.model.dao;

import com.phantom.model.entity.DealReview;

import java.util.List;

public interface DealReviewDao extends GenericDAO<DealReview, Long> {
    void saveReview(DealReview dealReview);

    boolean updateRecommendCount(String uuid);

    boolean updateReviewHelpfulCount(String uuid);

    boolean updateShareCount(String uuid);

    boolean makeDealReviewPrivate(String uuid);

    boolean makeDealReviewPublic(String uuid);

    boolean followDealReview(String uuid);

    boolean recommendForFuture(String uuid);

    List<DealReview> getReviewsByUserId(int userId);

    List<DealReview> getReviewsByDealId(String dealId);
}
