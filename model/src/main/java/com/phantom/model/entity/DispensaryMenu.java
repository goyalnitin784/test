package com.phantom.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dispensary_menu")
public class DispensaryMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "dispensary_id")
    private int dispensaryId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_category_type_id")
    private int productCategoryTypeId;

    @Column(name = "strain_category_type_id")
    private int strainCategoryTypeId;

    @Column(name = "strain_id")
    private int strainId;

    @Column(name = "breeder")
    private String breeder;

    @Column(name = "description")
    private String description;

    @Column(name = "image1")
    private String profileImage1;

    @Column(name = "image2")
    private String profileImage2;

    @Column(name = "image3")
    private String profileImage3;

    @Column(name = "other_details")
    private String otherDetails;

    @Column(name = "cbd_level")
    private String cbdLevel;

    @Column(name = "thc_level")
    private String thcLevel;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "last_updated_on")
    private Date lastUpdatedOn;

    @Column(name = "uuid")
    private String uuid;


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

    public String getBreeder() {
        return breeder;
    }

    public void setBreeder(String breeder) {
        this.breeder = breeder;
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
}

