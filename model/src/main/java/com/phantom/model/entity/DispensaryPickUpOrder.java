package com.phantom.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dispensary_pick_up_order")
public class DispensaryPickUpOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "dispensary_id")
    private int dispensaryId;

    @Column(name = "dispensary_pick_up_order_code")
    private String dispensaryPickUpOrderCode;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "pick_up_date")
    private Date pickUpDate;

    @Column(name = "pick_up_time_slot")
    private String pickUpTimeSlot;

    @Column(name = "special_comments")
    private String specialComments;

    @Column(name = "pick_up_order_status")
    private int pickUpOrderStatus;

    @Column(name = "pick_up_requested_on")
    private Date pickUpRequestedOn;

    @Column(name = "picked_up_by")
    private String pickedUpBy;

    @Column(name = "total_cost")
    private String totalCost;

    @Column(name = "pick_up_picked_on")
    private Date pickUpPickedOn;

    @Column(name = "last_updated_on")
    private Date lastUpdatedOn;

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

    public int getPickUpOrderStatus() {
        return pickUpOrderStatus;
    }

    public void setPickUpOrderStatus(int pickUpOrderStatus) {
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

    public Date getPickUpPickedOn() {
        return pickUpPickedOn;
    }

    public void setPickUpPickedOn(Date pickUpPickedOn) {
        this.pickUpPickedOn = pickUpPickedOn;
    }

    public Date getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(Date lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}

