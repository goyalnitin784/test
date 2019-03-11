package com.phantom.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "strain_review")
public class StrainReview {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "strain_id")
    private int strainId;

    @Column(name = "reviewer_user_id")
    private int reviewerUserId;

    @Column(name = "review_desc")
    private String reviewDesc;

    @Column(name = "rating")
    private int rating;

    @Column(name = "recommendation_count")
    private int recommendationCount;

    @Column(name = "is_review_helpful_count")
    private int isReviewHelpfulCount;

    @Column(name = "no_of_shares_count")
    private int sharesCount;

    @Column(name = "Consumption_form")
    private int consumptionForm;

    @Column(name = "consumption_method")
    private int consumptionMethod;

    @Column(name = "effects_information")
    private String effectsInfo;

    @Column(name = "medical_conditions")
    private String medicalConditions;

    @Column(name = "flavours")
    private String flavours;

    @Column(name = "thc_percentage")
    private String thcPercentage;

    @Column(name = "acquiredFrom")
    private String acquiredFrom;

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

    public int getStrainId() {
        return strainId;
    }

    public void setStrainId(int strainId) {
        this.strainId = strainId;
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

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
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

    public int getConsumptionForm() {
        return consumptionForm;
    }

    public void setConsumptionForm(int consumptionForm) {
        this.consumptionForm = consumptionForm;
    }

    public int getConsumptionMethod() {
        return consumptionMethod;
    }

    public void setConsumptionMethod(int consumptionMethod) {
        this.consumptionMethod = consumptionMethod;
    }

    public String getEffectsInfo() {
        return effectsInfo;
    }

    public void setEffectsInfo(String effectsInfo) {
        this.effectsInfo = effectsInfo;
    }

    public String getMedicalConditions() {
        return medicalConditions;
    }

    public void setMedicalConditions(String medicalConditions) {
        this.medicalConditions = medicalConditions;
    }

    public String getFlavours() {
        return flavours;
    }

    public void setFlavours(String flavours) {
        this.flavours = flavours;
    }

    public String getThcPercentage() {
        return thcPercentage;
    }

    public void setThcPercentage(String thcPercentage) {
        this.thcPercentage = thcPercentage;
    }

    public String getAcquiredFrom() {
        return acquiredFrom;
    }

    public void setAcquiredFrom(String acquiredFrom) {
        this.acquiredFrom = acquiredFrom;
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

