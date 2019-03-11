package com.phantom.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dispensary_menu")
public class DispensaryMenu {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "dispensary_id")
    private int Dispensary_id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_category_type_id")
    private int productCategoryTypeId;

    @Column(name = "strain_category_type_id")
    private int strainCategoryTypeId;

    @Column(name = "strain_id")
    private int strainId;

    @Column(name = "from")
    private String from;

    @Column(name = "description")
    private String description;

    @Column(name = "profile_image1")
    private String profileImage1;

    @Column(name = "profile_image2")
    private String profileImage2;

    @Column(name = "profile_image3")
    private String profileImage3;

    @Column(name = "other_details")
    private String otherDetails;

    @Column(name = "cbd_level")
    private String cbdLevel;

    @Column(name = "thc_level")
    private String thcLevel;

    @Column(name = "created_on")
    private Date createdOn;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDispensary_id() {
        return Dispensary_id;
    }

    public void setDispensary_id(int dispensary_id) {
        Dispensary_id = dispensary_id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductCategoryTypeId() {
        return productCategoryTypeId;
    }

    public void setProductCategoryTypeId(int productCategoryTypeId) {
        this.productCategoryTypeId = productCategoryTypeId;
    }

    public int getStrainCategoryTypeId() {
        return strainCategoryTypeId;
    }

    public void setStrainCategoryTypeId(int strainCategoryTypeId) {
        this.strainCategoryTypeId = strainCategoryTypeId;
    }

    public int getStrainId() {
        return strainId;
    }

    public void setStrainId(int strainId) {
        this.strainId = strainId;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProfileImage1() {
        return profileImage1;
    }

    public void setProfileImage1(String profileImage1) {
        this.profileImage1 = profileImage1;
    }

    public String getProfileImage2() {
        return profileImage2;
    }

    public void setProfileImage2(String profileImage2) {
        this.profileImage2 = profileImage2;
    }

    public String getProfileImage3() {
        return profileImage3;
    }

    public void setProfileImage3(String profileImage3) {
        this.profileImage3 = profileImage3;
    }

    public String getOtherDetails() {
        return otherDetails;
    }

    public void setOtherDetails(String otherDetails) {
        this.otherDetails = otherDetails;
    }

    public String getCbdLevel() {
        return cbdLevel;
    }

    public void setCbdLevel(String cbdLevel) {
        this.cbdLevel = cbdLevel;
    }

    public String getThcLevel() {
        return thcLevel;
    }

    public void setThcLevel(String thcLevel) {
        this.thcLevel = thcLevel;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}

