package com.phantom.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dispensary_deals")
public class DispensaryDeals {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "dispensary_id")
    private int dispensaryId;

    @Column(name = "deal_name")
    private String dealName;

    @Column(name = "validity_begin")
    private Date validityBeginDate;

    @Column(name = "validity_end")
    private Date validEndDate;

    @Column(name = "Deal_Description")
    private String dealDesc;

    @Column(name = "voucher_code")
    private String voucherCode;

    @Column(name = "deal_tag_line")
    private String dealTagLine;

    @Column(name = "discount_percentage")
    private String discountPercentage;

    @Column(name = "deal_image_1")
    private String dealImage1;

    @Column(name = "deal_image_2")
    private String dealImage2;

    @Column(name = "istrendingdeal")
    private int isTrendingDeal;

    @Column(name = "isfeatureddeal")
    private int isFeaturedDeal;

    @Column(name = "isActive")
    private int isActive;

    @Column(name = "price")
    private int price;

    @Column(name = "special_comments")
    private String specialComments;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "last_updated_on")
    private Date lastUpdatedOn;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "no_of_followers_count")
    private int followers;

    @Column(name = "total_likes")
    private int likes;

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

    public String getDealName() {
        return dealName;
    }

    public void setDealName(String dealName) {
        this.dealName = dealName;
    }

    public Date getValidityBeginDate() {
        return validityBeginDate;
    }

    public void setValidityBeginDate(Date validityBeginDate) {
        this.validityBeginDate = validityBeginDate;
    }

    public Date getValidEndDate() {
        return validEndDate;
    }

    public void setValidEndDate(Date validEndDate) {
        this.validEndDate = validEndDate;
    }

    public String getDealDesc() {
        return dealDesc;
    }

    public void setDealDesc(String dealDesc) {
        this.dealDesc = dealDesc;
    }

    public String getVoucherCode() {
        return voucherCode;
    }

    public void setVoucherCode(String voucherCode) {
        this.voucherCode = voucherCode;
    }

    public String getDealTagLine() {
        return dealTagLine;
    }

    public void setDealTagLine(String dealTagLine) {
        this.dealTagLine = dealTagLine;
    }

    public String getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(String discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public String getDealImage1() {
        return dealImage1;
    }

    public void setDealImage1(String dealImage1) {
        this.dealImage1 = dealImage1;
    }

    public String getDealImage2() {
        return dealImage2;
    }

    public void setDealImage2(String dealImage2) {
        this.dealImage2 = dealImage2;
    }

    public int getIsTrendingDeal() {
        return isTrendingDeal;
    }

    public void setIsTrendingDeal(int isTrendingDeal) {
        this.isTrendingDeal = isTrendingDeal;
    }

    public int getIsFeaturedDeal() {
        return isFeaturedDeal;
    }

    public void setIsFeaturedDeal(int isFeaturedDeal) {
        this.isFeaturedDeal = isFeaturedDeal;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getSpecialComments() {
        return specialComments;
    }

    public void setSpecialComments(String specialComments) {
        this.specialComments = specialComments;
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

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
}

