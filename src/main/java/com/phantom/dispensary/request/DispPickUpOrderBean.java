package com.phantom.dispensary.request;

import com.phantom.logging.PhantomLogger;
import com.phantom.request.MapBasedRequest;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class DispPickUpOrderBean extends MapBasedRequest {
    private static final PhantomLogger logger = PhantomLogger.getLoggerObject(DispMenuBean.class);
    private static final long serialVersionUID = -7221138766184943488L;

    private int dispensaryId;
    private String dispensaryPickUpOrderCode;
    private int userId;
    private Date pickUpDate;
    private String pickUpTimeSlot;
    private String specialComments;
    private String pickUpOrderStatus;
    private Date pickUpRequestedOn;
    private String pickedUpBy;
    private String totalCost;
    private String pickUpPickedOn;;

    private String uuid = UUID.randomUUID().toString();
    private boolean isValidPickUpOrder = Boolean.TRUE;

    public DispPickUpOrderBean(HttpServletRequest request) {
        super(request);
        postConstruct();
    }

    public DispPickUpOrderBean(Map<String, String> requestMap) {
        requestParameters = requestMap;
        postConstruct();
    }

    private void postConstruct() {
        try {
            dispensaryId = Integer.parseInt(requestParameters.get("dispId"));
            userId = Integer.parseInt(requestParameters.get("userId"));
            dispensaryPickUpOrderCode = requestParameters.get("dispPickUpOrderCode");
            if(StringUtils.isEmpty(dispensaryPickUpOrderCode)){
                isValidPickUpOrder = Boolean.FALSE;
            }
        } catch (Exception e) {
            logger.error("Exception occurred while adding dispensary pick up order ", e);
            isValidPickUpOrder = Boolean.FALSE;
        }
        if (isValidPickUpOrder) {
            try{
                pickUpDate = new SimpleDateFormat("yyyy-MM-dd").parse(requestParameters.get("pickUpDate"));
                pickUpRequestedOn = new SimpleDateFormat("yyyy-MM-dd").parse(requestParameters.get("pickUpRequestedOn"));
                pickUpOrderStatus = requestParameters.get("pickUpOrderStatus");
            }catch (Exception e){
            }
            pickUpTimeSlot = requestParameters.get("pickUpTimeSlot");
            specialComments = requestParameters.get("specialComments");
            pickedUpBy = requestParameters.get("pickedUpBy");
            totalCost = requestParameters.get("totalCost");
            pickUpPickedOn = requestParameters.get("pickUpPickedOn");
        }
    }

    public int getDispensaryId() {
        return dispensaryId;
    }

    public void setDispensaryId(int dispensaryId) {
        this.dispensaryId = dispensaryId;
    }

    public String getDispensaryPickUpOrderCode() {
        return dispensaryPickUpOrderCode;
    }

    public void setDispensaryPickUpOrderCode(String dispensaryPickUpOrderCode) {
        this.dispensaryPickUpOrderCode = dispensaryPickUpOrderCode;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(Date pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public String getPickUpTimeSlot() {
        return pickUpTimeSlot;
    }

    public void setPickUpTimeSlot(String pickUpTimeSlot) {
        this.pickUpTimeSlot = pickUpTimeSlot;
    }

    public String getSpecialComments() {
        return specialComments;
    }

    public void setSpecialComments(String specialComments) {
        this.specialComments = specialComments;
    }

    public String getPickUpOrderStatus() {
        return pickUpOrderStatus;
    }

    public void setPickUpOrderStatus(String pickUpOrderStatus) {
        this.pickUpOrderStatus = pickUpOrderStatus;
    }

    public Date getPickUpRequestedOn() {
        return pickUpRequestedOn;
    }

    public void setPickUpRequestedOn(Date pickUpRequestedOn) {
        this.pickUpRequestedOn = pickUpRequestedOn;
    }

    public String getPickedUpBy() {
        return pickedUpBy;
    }

    public void setPickedUpBy(String pickedUpBy) {
        this.pickedUpBy = pickedUpBy;
    }

    public String getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(String totalCost) {
        this.totalCost = totalCost;
    }

    public String getPickUpPickedOn() {
        return pickUpPickedOn;
    }

    public void setPickUpPickedOn(String pickUpPickedOn) {
        this.pickUpPickedOn = pickUpPickedOn;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public boolean isValidPickUpOrder() {
        return isValidPickUpOrder;
    }

    public void setValidPickUpOrder(boolean validPickUpOrder) {
        isValidPickUpOrder = validPickUpOrder;
    }
}
