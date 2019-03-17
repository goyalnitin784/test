package com.phantom.user.request;


import com.phantom.request.MapBasedRequest;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.UUID;

public class UserBean extends MapBasedRequest {
    private static final long serialVersionUID = 7682719590873299457L;

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
    private String ssoToken = UUID.randomUUID().toString();
    private boolean isValidUser = false;

    public UserBean(HttpServletRequest request) {
        super(request);
        postConstruct();
    }

    public UserBean(Map<String,String> requestMap){
        requestParameters = requestMap;
        postConstruct();
    }
    private void postConstruct() {
        userType = Integer.parseInt(requestParameters.get("userType"));
        userName = requestParameters.get("userName");
        password = requestParameters.get("password");
        title = requestParameters.get("title");
        firstName = requestParameters.get("firstName");
        lastName = requestParameters.get("lastName");
        profilePic = requestParameters.get("profilePic");
        phoneNo = requestParameters.get("phoneNo");
        email = requestParameters.get("email");
        dob = requestParameters.get("dob");
        isValidUser = !StringUtils.isEmpty(userName) && !StringUtils.isEmpty(password) && !StringUtils.isEmpty(email)
                && !StringUtils.isEmpty(dob);
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

    @Override
    public String toString() {
        return "UserBean{" +
                "userType=" + userType +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", profilePic='" + profilePic + '\'' +
                ", phoneNo='" + phoneNo + '\'' +
                ", email='" + email + '\'' +
                ", dob='" + dob + '\'' +
                '}';
    }
}
