package com.phantom.dispensary.request;

import com.phantom.logging.PhantomLogger;
import com.phantom.request.MapBasedRequest;
import com.phantom.util.PhantomUtil;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import java.util.UUID;

public class DispMenuBean extends MapBasedRequest {
    private static final PhantomLogger logger = PhantomLogger.getLoggerObject(DispMenuBean.class);
    private static final long serialVersionUID = 3482944622809281079L;

    private int dispensaryId;
    private String productName;
    private int productCategoryTypeId = -1;
    private int strainCategoryTypeId = -1;
    private int strainId = -1;
    private String breeder;
    private String description;
    private String profileImage1;
    private String profileImage2;
    private String profileImage3;
    private String otherDetails;
    private String cbdLevel;
    private String thcLevel;

    private String uuid = UUID.randomUUID().toString();
    private boolean isValidMenu = Boolean.TRUE;

    public DispMenuBean(HttpServletRequest request) {
        super(request);
        postConstruct();
    }

    public DispMenuBean(Map<String, String> requestMap) {
        requestParameters = requestMap;
        postConstruct();
    }

    private void postConstruct() {

        if (!PhantomUtil.isNullOrEmpty(requestParameters.get("productCatTypeId"))) {
            productCategoryTypeId = Integer.parseInt(requestParameters.get("productCatTypeId"));
        }
        if (!PhantomUtil.isNullOrEmpty(requestParameters.get("strainCatTypeId"))) {
            strainCategoryTypeId = Integer.parseInt(requestParameters.get("strainCatTypeId"));
        }
        if (!PhantomUtil.isNullOrEmpty(requestParameters.get("strainId"))) {
            strainId = Integer.parseInt(requestParameters.get("strainId"));
        }
        productName = requestParameters.get("productName");
        breeder = requestParameters.get("breeder");
        description = requestParameters.get("desc");
        profileImage1 = requestParameters.get("image1");
        profileImage2 = requestParameters.get("image2");
        profileImage3 = requestParameters.get("image3");
        otherDetails = requestParameters.get("otherDetails");
        cbdLevel = requestParameters.get("cbdLevel");
        thcLevel = requestParameters.get("thcLevel");

        if (StringUtils.isEmpty(productName) || StringUtils.isEmpty(breeder)
                || StringUtils.isEmpty(profileImage1) || StringUtils.isEmpty(profileImage2)
                || productCategoryTypeId == -1 || strainCategoryTypeId == -1 || strainId == -1) {
            isValidMenu = Boolean.FALSE;
        }
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

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public boolean isValidMenu() {
        return isValidMenu;
    }

    public void setValidMenu(boolean validMenu) {
        isValidMenu = validMenu;
    }
}
