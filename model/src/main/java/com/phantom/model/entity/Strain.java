package com.phantom.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "strain")
public class Strain {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "is_trending_strain")
    private int isTrendingStrain;

    @Column(name = "is_featured_strain")
    private int isFeaturedStrain;

    @Column(name = "cbd")
    private String cbd;

    @Column(name = "thc")
    private String thc;

    @Column(name = "from")
    private String from;

    @Column(name = "strain_name")
    private String strainName;

    @Column(name = "strain_description")
    private String strainDescription;

    @Column(name = "short_description")
    private String shortDescription;

    @Column(name = "profile_image1")
    private String profileImage1;

    @Column(name = "profile_image2")
    private String profileImage2;

    @Column(name = "profile_image3")
    private String profileImage3;

    @Column(name = "other_details")
    private String otherDetails;

    @Column(name = "origin_details")
    private String originDetails;

    @Column(name = "origin_image")
    private String originImage;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "uuid")
    private String uuid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int isTrendingStrain() {
        return isTrendingStrain;
    }

    public void setTrendingStrain(int trendingStrain) {
        isTrendingStrain = trendingStrain;
    }

    public int isFeaturedStrain() {
        return isFeaturedStrain;
    }

    public void setFeaturedStrain(int featuredStrain) {
        isFeaturedStrain = featuredStrain;
    }

    public String getCbd() {
        return cbd;
    }

    public void setCbd(String cbd) {
        this.cbd = cbd;
    }

    public String getThc() {
        return thc;
    }

    public void setThc(String thc) {
        this.thc = thc;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getStrainName() {
        return strainName;
    }

    public void setStrainName(String strainName) {
        this.strainName = strainName;
    }

    public String getStrainDescription() {
        return strainDescription;
    }

    public void setStrainDescription(String strainDescription) {
        this.strainDescription = strainDescription;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
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

    public String getOriginDetails() {
        return originDetails;
    }

    public void setOriginDetails(String originDetails) {
        this.originDetails = originDetails;
    }

    public String getOriginImage() {
        return originImage;
    }

    public void setOriginImage(String originImage) {
        this.originImage = originImage;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public int getIsTrendingStrain() {
        return isTrendingStrain;
    }

    public void setIsTrendingStrain(int isTrendingStrain) {
        this.isTrendingStrain = isTrendingStrain;
    }

    public int getIsFeaturedStrain() {
        return isFeaturedStrain;
    }

    public void setIsFeaturedStrain(int isFeaturedStrain) {
        this.isFeaturedStrain = isFeaturedStrain;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}

