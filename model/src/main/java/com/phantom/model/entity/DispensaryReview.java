package com.phantom.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dispensary_review")
public class DispensaryReview {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "dispensary_id")
    private int dispensaryId;

    @Column(name = "reviewer_user_id")
    private int reviewerUserId;

    @Column(name = "review_desc")
    private String reviewDesc;

    @Column(name = "service_rating")
    private int serviceRating;

    @Column(name = "atmosphere_rating")
    private int atmosphereRating;

    @Column(name = "recommendation_count")
    private int recommendationCount;

    @Column(name = "is_review_helpful_count")
    private int isReviewHelpfulCount;

    @Column(name = "no_of_shares_count")
    private int sharesCount;

    @Column(name = "quality_rating")
    private int qualityRating;

    @Column(name = "make_review_private")
    private boolean makeReviewPrivate;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "created_on")
    private Date createdOn;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDispensaryId() {
        return dispensaryId;
    }

    public void setDispensaryId(int dispensaryId) {
        this.dispensaryId = dispensaryId;
    }

    public int getReviewerUserId() {
        return reviewerUserId;
    }

    public void setReviewerUserId(int reviewerUserId) {
        this.reviewerUserId = reviewerUserId;
    }

    public String getReviewDesc() {
        return reviewDesc;
    }

    public void setReviewDesc(String reviewDesc) {
        this.reviewDesc = reviewDesc;
    }

    public int getServiceRating() {
        return serviceRating;
    }

    public void setServiceRating(int serviceRating) {
        this.serviceRating = serviceRating;
    }

    public int getAtmosphereRating() {
        return atmosphereRating;
    }

    public void setAtmosphereRating(int atmosphereRating) {
        this.atmosphereRating = atmosphereRating;
    }

    public int getRecommendationCount() {
        return recommendationCount;
    }

    public void setRecommendationCount(int recommendationCount) {
        this.recommendationCount = recommendationCount;
    }

    public int getIsReviewHelpfulCount() {
        return isReviewHelpfulCount;
    }

    public void setIsReviewHelpfulCount(int isReviewHelpfulCount) {
        this.isReviewHelpfulCount = isReviewHelpfulCount;
    }

    public int getSharesCount() {
        return sharesCount;
    }

    public void setSharesCount(int sharesCount) {
        this.sharesCount = sharesCount;
    }

    public int getQualityRating() {
        return qualityRating;
    }

    public void setQualityRating(int qualityRating) {
        this.qualityRating = qualityRating;
    }

    public boolean isMakeReviewPrivate() {
        return makeReviewPrivate;
    }

    public void setMakeReviewPrivate(boolean makeReviewPrivate) {
        this.makeReviewPrivate = makeReviewPrivate;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}

