package com.phantom.dispensary.request;

import com.phantom.logging.PhantomLogger;
import com.phantom.request.MapBasedRequest;
import com.sun.org.apache.bcel.internal.generic.DADD;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class DispDealsBean extends MapBasedRequest {
    private static final PhantomLogger logger = PhantomLogger.getLoggerObject(DispReviewBean.class);
    private static final long serialVersionUID = -1385933781114957223L;

    private int dispensaryId;
    private String dealName;
    private Date validityBeginDate;
    private Date validEndDate;
    private String dealDesc;
    private String voucherCode;
    private String dealTagLine;
    private String discountPercentage;
    private String dealImage1;
    private String dealImage2;
    private int isTrendingDeal = 0;
    private int isFeaturedDeal = 0;
    private int isActive = 1;
    private int price;
    private String specialComments;
    private int followers = 0;
    private String uuid = UUID.randomUUID().toString();
    private boolean isValidDeal = Boolean.TRUE;

    public DispDealsBean(HttpServletRequest request) {
        super(request);
        postConstruct();
    }

    public DispDealsBean(Map<String, String> requestMap) {
        requestParameters = requestMap;
        postConstruct();
    }

    private void postConstruct() {

        dealName = requestParameters.get("dealName");
        dealDesc = requestParameters.get("dealDesc");
        voucherCode = requestParameters.get("voucherCode");
        dealTagLine = requestParameters.get("dealTagLine");
        discountPercentage = requestParameters.get("discountPercentage");
        dealImage1 = requestParameters.get("dealImage1");
        dealImage2 = requestParameters.get("dealImage2");
        specialComments = requestParameters.get("specialComments");

        try {
            validityBeginDate = new SimpleDateFormat("yyyy-MM-dd").parse(requestParameters.get("validityBeginDate"));
            validEndDate = new SimpleDateFormat("yyyy-MM-dd").parse(requestParameters.get("validEndDate"));
        } catch (Exception e) {
        }
        if (requestParameters.get("price") != null) {
            price = Integer.parseInt(requestParameters.get("price"));
        }

        if (StringUtils.isEmpty(dealDesc) || StringUtils.isEmpty(dealName)) {
            isValidDeal = Boolean.FALSE;
        }
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

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public boolean isValidDeal() {
        return isValidDeal;
    }

    public void setValidDeal(boolean validDeal) {
        isValidDeal = validDeal;
    }
}
