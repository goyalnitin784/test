package com.phantom.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dispensary")
public class Dispensary {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "dispensary_name")
    private String dispensaryName;

    @Column(name = "dispensary_profile_pic")
    private String dispensaryProfilePic;

    @Column(name = "dispensary_desc")
    private String dispensaryDesc;

    @Column(name = "phone")
    private String phoneNo;

    @Column(name = "email")
    private String email;

    @Column(name = "website")
    private String website;

    @Column(name = "address")
    private String address;

    @Column(name = "longitude")
    private String longitude;

    @Column(name = "latitude")
    private String latitude;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "country")
    private String country;

    @Column(name = "facilities")
    private String facilities;

    @Column(name = "time_zone")
    private String timeZone;

    @Column(name = "monday_open_on")
    private String mondayOpenOn;

    @Column(name = "monday_closed_on")
    private String mondayClosedOn;

    @Column(name = "tuesday_open_on")
    private String tuesdayOpenOn;

    @Column(name = "tuesday_closed_on")
    private String tuesdayClosedOn;

    @Column(name = "wednesday_open_on")
    private String wednesdayOpenOn;

    @Column(name = "wednesday_closed_on")
    private String wednesdayClosedOn;

    @Column(name = "thursday_open_on")
    private String thursdayOpenOn;

    @Column(name = "thursday_closed_on")
    private String thursdayClosedOn;

    @Column(name = "friday_open_on")
    private String fridayOpenOn;

    @Column(name = "friday_closed_on")
    private String fridayClosedOn;

    @Column(name = "saturday_open_on")
    private String saturdayOpenOn;

    @Column(name = "saturday_closed_on")
    private String saturdayClosedOn;

    @Column(name = "sunday_open_on")
    private String sundayOpenOn;

    @Column(name = "sunday_closed_on")
    private String sundayClosedOn;

    @Column(name = "is_trending_dispensary")
    private boolean isTrendingDispensary;

    @Column(name = "is_featured_dispensary")
    private boolean isFeaturedDispensary;

    @Column(name = "date_of_joining")
    private Date dateOfJoining;

    @Column(name = "is_verified_listing")
    private boolean isVerifiedListing;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "no_of_followers_count")
    private int followersCount;

    @Column(name = "created_on")
    private Date createdOn;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDispensaryName() {
        return dispensaryName;
    }

    public void setDispensaryName(String dispensaryName) {
        this.dispensaryName = dispensaryName;
    }

    public String getDispensaryProfilePic() {
        return dispensaryProfilePic;
    }

    public void setDispensaryProfilePic(String dispensaryProfilePic) {
        this.dispensaryProfilePic = dispensaryProfilePic;
    }

    public String getDispensaryDesc() {
        return dispensaryDesc;
    }

    public void setDispensaryDesc(String dispensaryDesc) {
        this.dispensaryDesc = dispensaryDesc;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFacilities() {
        return facilities;
    }

    public void setFacilities(String facilities) {
        this.facilities = facilities;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getMondayOpenOn() {
        return mondayOpenOn;
    }

    public void setMondayOpenOn(String mondayOpenOn) {
        this.mondayOpenOn = mondayOpenOn;
    }

    public String getMondayClosedOn() {
        return mondayClosedOn;
    }

    public void setMondayClosedOn(String mondayClosedOn) {
        this.mondayClosedOn = mondayClosedOn;
    }

    public String getTuesdayOpenOn() {
        return tuesdayOpenOn;
    }

    public void setTuesdayOpenOn(String tuesdayOpenOn) {
        this.tuesdayOpenOn = tuesdayOpenOn;
    }

    public String getTuesdayClosedOn() {
        return tuesdayClosedOn;
    }

    public void setTuesdayClosedOn(String tuesdayClosedOn) {
        this.tuesdayClosedOn = tuesdayClosedOn;
    }

    public String getWednesdayOpenOn() {
        return wednesdayOpenOn;
    }

    public void setWednesdayOpenOn(String wednesdayOpenOn) {
        this.wednesdayOpenOn = wednesdayOpenOn;
    }

    public String getWednesdayClosedOn() {
        return wednesdayClosedOn;
    }

    public void setWednesdayClosedOn(String wednesdayClosedOn) {
        this.wednesdayClosedOn = wednesdayClosedOn;
    }

    public String getThursdayOpenOn() {
        return thursdayOpenOn;
    }

    public void setThursdayOpenOn(String thursdayOpenOn) {
        this.thursdayOpenOn = thursdayOpenOn;
    }

    public String getThursdayClosedOn() {
        return thursdayClosedOn;
    }

    public void setThursdayClosedOn(String thursdayClosedOn) {
        this.thursdayClosedOn = thursdayClosedOn;
    }

    public String getFridayOpenOn() {
        return fridayOpenOn;
    }

    public void setFridayOpenOn(String fridayOpenOn) {
        this.fridayOpenOn = fridayOpenOn;
    }

    public String getFridayClosedOn() {
        return fridayClosedOn;
    }

    public void setFridayClosedOn(String fridayClosedOn) {
        this.fridayClosedOn = fridayClosedOn;
    }

    public String getSaturdayOpenOn() {
        return saturdayOpenOn;
    }

    public void setSaturdayOpenOn(String saturdayOpenOn) {
        this.saturdayOpenOn = saturdayOpenOn;
    }

    public String getSaturdayClosedOn() {
        return saturdayClosedOn;
    }

    public void setSaturdayClosedOn(String saturdayClosedOn) {
        this.saturdayClosedOn = saturdayClosedOn;
    }

    public String getSundayOpenOn() {
        return sundayOpenOn;
    }

    public void setSundayOpenOn(String sundayOpenOn) {
        this.sundayOpenOn = sundayOpenOn;
    }

    public String getSundayClosedOn() {
        return sundayClosedOn;
    }

    public void setSundayClosedOn(String sundayClosedOn) {
        this.sundayClosedOn = sundayClosedOn;
    }

    public boolean isTrendingDispensary() {
        return isTrendingDispensary;
    }

    public void setTrendingDispensary(boolean trendingDispensary) {
        isTrendingDispensary = trendingDispensary;
    }

    public boolean isFeaturedDispensary() {
        return isFeaturedDispensary;
    }

    public void setFeaturedDispensary(boolean featuredDispensary) {
        isFeaturedDispensary = featuredDispensary;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public boolean isVerifiedListing() {
        return isVerifiedListing;
    }

    public void setVerifiedListing(boolean verifiedListing) {
        isVerifiedListing = verifiedListing;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}

