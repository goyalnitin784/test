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

    @Column(name = "validity_begin_date")
    private Date validityBeginDate;

    @Column(name = "valid_end_date")
    private Date validEndDate;

    @Column(name = "deal_desc")
    private String dealDesc;

    @Column(name = "voucher_code")
    private String voucherCode;

    @Column(name = "deal_tag_line")
    private String dealTagLine;

    @Column(name = "discount_percentage")
    private String discountPercentage;

    @Column(name = "deal_image1")
    private String dealImage1;

    @Column(name = "deal_image2")
    private String dealImage2;

    @Column(name = "is_trending_deal")
    private int isTrendingDeal;

    @Column(name = "is_featured_deal")
    private int isFeaturedDeal;

    @Column(name = "is_active")
    private int isActive;

    @Column(name = "price")
    private int price;

    @Column(name = "special_comments")
    private String specialComments;

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

    public int isTrendingDeal() {
        return isTrendingDeal;
    }

    public void setTrendingDeal(int trendingDeal) {
        isTrendingDeal = trendingDeal;
    }

    public int isFeaturedDeal() {
        return isFeaturedDeal;
    }

    public void setFeaturedDeal(int featuredDeal) {
        isFeaturedDeal = featuredDeal;
    }

    public int isActive() {
        return isActive;
    }

    public void setActive(int active) {
        isActive = active;
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
}

