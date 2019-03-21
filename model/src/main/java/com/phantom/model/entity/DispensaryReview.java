package com.phantom.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dispensary_review")
public class DispensaryReview {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "dispensary_id")
    private int dispensaryId;

    @Column(name = "Reviewer_User_id")
    private int reviewerUserId;

    @Column(name = "review_desc")
    private String reviewDesc;

    @Column(name = "Service_Rating")
    private int serviceRating;

    @Column(name = "Atmosphere_Rating")
    private int atmosphereRating;

    @Column(name = "Recommendation_Count")
    private int recommendationCount;

    @Column(name = "is_review_Helpful_count")
    private int isReviewHelpfulCount;

    @Column(name = "Number_Of_Shares_Count")
    private int sharesCount;

    @Column(name = "Quality_Rating")
    private int qualityRating;

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

    @Column(name = "overall_quality_rating")
    private int overAllQualityRating;

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

    public int getOverAllQualityRating() {
        return overAllQualityRating;
    }

    public void setOverAllQualityRating(int overAllQualityRating) {
        this.overAllQualityRating = overAllQualityRating;
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

