package com.phantom.dispensary.request;

import com.phantom.logging.PhantomLogger;
import com.phantom.request.MapBasedRequest;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class DispensaryBean extends MapBasedRequest {
    PhantomLogger phantomLogger = PhantomLogger.getLoggerObject(DispensaryBean.class);
    private static final long serialVersionUID = 8628580855471172668L;

    private long dispensaryId;
    private String dispensaryName;
    private String dispensaryProfilePic;
    private String dispensaryDesc;
    private String phoneNo;
    private String email;
    private String website;
    private String address;
    private String longitude;
    private String latitude;
    private String city;
    private String state;
    private String country;
    private String facilities;
    private String timeZone;
    private String mondayOpenOn;
    private String mondayClosedOn;
    private String tuesdayOpenOn;
    private String tuesdayClosedOn;
    private String wednesdayOpenOn;
    private String wednesdayClosedOn;
    private String thursdayOpenOn;
    private String thursdayClosedOn;
    private String fridayOpenOn;
    private String fridayClosedOn;
    private String saturdayOpenOn;
    private String saturdayClosedOn;
    private String sundayOpenOn;
    private String sundayClosedOn;
    private int isTrendingDispensary = 0;
    private int isFeaturedDispensary = 0;
    private Date dateOfJoining;
    private int isVerifiedListing = 0;
    private int isActive = 0;
    private int followersCount = 0;

    private String uuid = UUID.randomUUID().toString();
    private boolean isValidDispensary = false;

    public DispensaryBean(HttpServletRequest request) {
        super(request);
        postConstruct();
    }

    public DispensaryBean(Map<String, String> requestMap) {
        requestParameters = requestMap;
        postConstruct();
    }

    private void postConstruct() {
        dispensaryName = requestParameters.get("dispensaryName");
        dispensaryProfilePic = requestParameters.get("dispensaryProfilePic");
        dispensaryDesc = requestParameters.get("dispensaryDesc");
        phoneNo = requestParameters.get("phoneNo");
        email = requestParameters.get("email");
        website = requestParameters.get("website");
        address = requestParameters.get("address");
        longitude = requestParameters.get("longitude");
        latitude = requestParameters.get("latitude");
        city = requestParameters.get("city");
        state = requestParameters.get("state");
        country = requestParameters.get("country");
        facilities = requestParameters.get("facilities");
        timeZone = requestParameters.get("timeZone");
        mondayOpenOn = requestParameters.get("mondayOpenOn");
        mondayClosedOn = requestParameters.get("mondayClosedOn");
        tuesdayOpenOn = requestParameters.get("tuesdayOpenOn");
        tuesdayClosedOn = requestParameters.get("tuesdayClosedOn");
        wednesdayOpenOn = requestParameters.get("wednesdayOpenOn");
        wednesdayClosedOn = requestParameters.get("wednesdayClosedOn");
        thursdayOpenOn = requestParameters.get("thursdayOpenOn");
        thursdayClosedOn = requestParameters.get("thursdayClosedOn");
        fridayOpenOn = requestParameters.get("fridayOpenOn");
        fridayClosedOn = requestParameters.get("fridayClosedOn");
        saturdayOpenOn = requestParameters.get("saturdayOpenOn");
        saturdayClosedOn = requestParameters.get("saturdayClosedOn");
        sundayOpenOn = requestParameters.get("sundayOpenOn");
        sundayClosedOn = requestParameters.get("sundayClosedOn");
        if (requestParameters.get("isTrendingDispensary") != null) {
            isTrendingDispensary = Integer.parseInt(requestParameters.get("isTrendingDispensary"));
        }
        if (requestParameters.get("isFeaturedDispensary") != null) {
            isFeaturedDispensary = Integer.parseInt(requestParameters.get("isFeaturedDispensary"));
        }
        try {
            dateOfJoining = new SimpleDateFormat("yyyy-MM-dd").parse(requestParameters.get("dateOfJoining"));
        } catch (Exception e) {
            phantomLogger.error("Exception occurred while parsing date of joining ", e);
        }
        if (requestParameters.get("isVerifiedListing") != null) {
            isVerifiedListing = Integer.parseInt(requestParameters.get("isVerifiedListing"));
        }
        if (requestParameters.get("isActive") != null) {
            isActive = Integer.parseInt(requestParameters.get("isActive"));
        }
        if (requestParameters.get("followersCount") != null) {
            followersCount = Integer.parseInt(requestParameters.get("followersCount"));
        }

        isValidDispensary = !StringUtils.isEmpty(dispensaryName) && !StringUtils.isEmpty(email);
    }

    public long getDispensaryId() {
        return dispensaryId;
    }

    public void setDispensaryId(long dispensaryId) {
        this.dispensaryId = dispensaryId;
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

    public int getIsTrendingDispensary() {
        return isTrendingDispensary;
    }

    public void setIsTrendingDispensary(int isTrendingDispensary) {
        this.isTrendingDispensary = isTrendingDispensary;
    }

    public int getIsFeaturedDispensary() {
        return isFeaturedDispensary;
    }

    public void setIsFeaturedDispensary(int isFeaturedDispensary) {
        this.isFeaturedDispensary = isFeaturedDispensary;
    }

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public int getIsVerifiedListing() {
        return isVerifiedListing;
    }

    public void setIsVerifiedListing(int isVerifiedListing) {
        this.isVerifiedListing = isVerifiedListing;
    }

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public int getFollowersCount() {
        return followersCount;
    }

    public void setFollowersCount(int followersCount) {
        this.followersCount = followersCount;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public boolean isValidDispensary() {
        return isValidDispensary;
    }

    public void setValidDispensary(boolean validDispensary) {
        isValidDispensary = validDispensary;
    }


}
