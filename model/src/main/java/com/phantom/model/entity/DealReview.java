package com.phantom.model.entity;

import org.springframework.stereotype.Controller;

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

    @Column(name = "overall_quality_rating")
    private int overAllRating;

    @Column(name = "recommendation_count")
    private int recommendationCount;

    @Column(name = "is_review_helpful_count")
    private int isReviewHelpfulCount;

    @Column(name = "Number_Of_Shares_Count")
    private int sharesCount;

    @Column(name = "value_for_money_rating")
    private int valueForMoneyRating;

    @Column(name = "deal_correctness_Rating")
    private int dealCorrectnessRating;

    @Column(name = "recommend_for_future")
    private int recommendForFuture;

    @Column(name = "make_review_private")
    private int makeReviewPrivate;

    @Column(name = "is_active")
    private int isActive;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "last_updated_on")
    private Date lastUpdatedOn;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "reviewed_on")
    private Date reviewedOn;

    @Column(name = "count_of_followers")
    private int followers;

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

    public int getOverAllRating() {
        return overAllRating;
    }

    public void setOverAllRating(int overAllRating) {
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

    public int getDealCorrectnessRating() {
        return dealCorrectnessRating;
    }

    public void setDealCorrectnessRating(int dealCorrectnessRating) {
        this.dealCorrectnessRating = dealCorrectnessRating;
    }

    public int getRecommendForFuture() {
        return recommendForFuture;
    }

    public void setRecommendForFuture(int recommendForFuture) {
        this.recommendForFuture = recommendForFuture;
    }

    public int getMakeReviewPrivate() {
        return makeReviewPrivate;
    }

    public void setMakeReviewPrivate(int makeReviewPrivate) {
        this.makeReviewPrivate = makeReviewPrivate;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(Date lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Date getReviewedOn() {
        return reviewedOn;
    }

    public void setReviewedOn(Date reviewedOn) {
        this.reviewedOn = reviewedOn;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }
}

