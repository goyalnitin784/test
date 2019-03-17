package com.phantom.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "deal_review")
public class DealReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "deal_id")
    private int dealId;

    @Column(name = "dispensary_id")
    private int dispensaryId;

    @Column(name = "reviewer_user_id")
    private int reviewerUserId;

    @Column(name = "review_desc")
    private String reviewDesc;

    @Column(name = "overall_rating")
    private double overAllRating;

    @Column(name = "recommendation_count")
    private int recommendationCount;

    @Column(name = "is_review_helpful_count")
    private int isReviewHelpfulCount;

    @Column(name = "no_of_shares_count")
    private int sharesCount;

    @Column(name = "value_for_money_rating")
    private int valueForMoneyRating;

    @Column(name = "deal_correctness")
    private int dealCorrectness;

    @Column(name = "quality_rating")
    private int qualityRating;

    @Column(name = "will_take_deal_future_count")
    private int willTakeDealFutureCount;

    @Column(name = "make_review_private")
    private int makeReviewPrivate;

    @Column(name = "is_active")
    private int isActive;

    @Column(name = "created_on")
    private Date createdOn;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDealId() {
        return dealId;
    }

    public void setDealId(int dealId) {
        this.dealId = dealId;
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

    public double getOverAllRating() {
        return overAllRating;
    }

    public void setOverAllRating(double overAllRating) {
        this.overAllRating = overAllRating;
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

    public int getValueForMoneyRating() {
        return valueForMoneyRating;
    }

    public void setValueForMoneyRating(int valueForMoneyRating) {
        this.valueForMoneyRating = valueForMoneyRating;
    }

    public int getDealCorrectness() {
        return dealCorrectness;
    }

    public void setDealCorrectness(int dealCorrectness) {
        this.dealCorrectness = dealCorrectness;
    }

    public int getQualityRating() {
        return qualityRating;
    }

    public void setQualityRating(int qualityRating) {
        this.qualityRating = qualityRating;
    }

    public int getWillTakeDealFutureCount() {
        return willTakeDealFutureCount;
    }

    public void setWillTakeDealFutureCount(int willTakeDealFutureCount) {
        this.willTakeDealFutureCount = willTakeDealFutureCount;
    }

    public int isMakeReviewPrivate() {
        return makeReviewPrivate;
    }

    public void setMakeReviewPrivate(int makeReviewPrivate) {
        this.makeReviewPrivate = makeReviewPrivate;
    }

    public int isActive() {
        return isActive;
    }

    public void setActive(int active) {
        isActive = active;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}

