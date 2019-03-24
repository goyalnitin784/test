package com.phantom.business.user.request;


import com.phantom.request.MapBasedRequest;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.UUID;

public class BusinessUserBean extends MapBasedRequest {
    private static final long serialVersionUID = -6642957764091515832L;

    private long businessUserId;
    private int userType;
    private String title = "";
    private String firstName = "";
    private String lastName = "";
    private String userName;
    private String password;
    private String profilePic;
    private String phoneNo;
    private String email;
    private String dob;
    private int dispensaryId;
    private String ssoToken = UUID.randomUUID().toString();
    private boolean isValidUser = false;

    public BusinessUserBean(HttpServletRequest request) {
        super(request);
        postConstruct();
    }
    public BusinessUserBean(Map<String,String> requestMap){
        requestParameters = requestMap;
        postConstruct();
    }
    private void postConstruct() {
        userType = Integer.parseInt(requestParameters.get("userType"));
        userName = requestParameters.get("userName");
        password = requestParameters.get("password");
        profilePic = requestParameters.get("profilePic");
        phoneNo = requestParameters.get("phoneNo");
        email = requestParameters.get("email");
        dob = requestParameters.get("dob");
        dispensaryId = Integer.parseInt(requestParameters.get("dispensaryId"));
        isValidUser = !StringUtils.isEmpty(userName) && !StringUtils.isEmpty(password) && !StringUtils.isEmpty(email)
                && !StringUtils.isEmpty(dob);
    }

    public long getBusinessUserId() {
        return businessUserId;
    }

    public void setBusinessUserId(long businessUserId) {
        this.businessUserId = businessUserId;
    }

    public int getUserType() {
        return userType;
    }

    public void setUserType(int userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public boolean isValidUser() {
        return isValidUser;
    }

    public void setValidUser(boolean validUser) {
        isValidUser = validUser;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSsoToken() {
        return ssoToken;
    }

    public void setSsoToken(String ssoToken) {
        this.ssoToken = ssoToken;
    }

    public int getDispensaryId() {
        return dispensaryId;
    }

    public void setDispensaryId(int dispensaryId) {
        this.dispensaryId = dispensaryId;
    }


    @Override
    public String toString() {
        return "BusinessUserBean{" +
                "userType=" + userType +
                ", title='" + title + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", profilePic='" + profilePic + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", email='" + email + '\'' +
                ", dob='" + dob + '\'' +
                ", dispensaryId=" + dispensaryId +
                ", ssoToken='" + ssoToken + '\'' +
                ", isValidUser=" + isValidUser +
                '}';
    }
}
