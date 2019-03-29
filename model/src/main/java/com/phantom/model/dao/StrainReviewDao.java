package com.phantom.model.dao;

import com.phantom.model.entity.StrainReview;

import java.util.List;

public interface StrainReviewDao extends GenericDAO<StrainReview, Long> {
    List<StrainReview> getReviewsByUserId(int userId);
    boolean makeReviewPrivate(String uuid);
}
