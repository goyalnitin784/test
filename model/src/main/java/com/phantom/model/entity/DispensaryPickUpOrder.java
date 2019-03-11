package com.phantom.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dispensary_pick_up_order")
public class DispensaryPickUpOrder {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "dispensary_id")
    private int dispensaryId;

    @Column(name = "dispensary_pick_up_order_code")
    private int dispensaryPickUpOrderCode;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "pick_up_date")
    private Date pickUpDate;

    @Column(name = "pick_up_time_slot")
    private String pickUpTimeSlot;

    @Column(name = "special_commnets")
    private String specialCommnets;

    @Column(name = "pick_up_order_status")
    private int pickUpOrderStatus;

    @Column(name = "pick_up_requested_on")
    private Date pickUpRequestedOn;

    @Column(name = "pick_up_by")
    private String pickUpBy;

    @Column(name = "totalCost")
    private String totalCost;

    @Column(name = "pick_up_picked_on")
    private Date pickUpPickedOn;

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

    public int getDispensaryPickUpOrderCode() {
        return dispensaryPickUpOrderCode;
    }

    public void setDispensaryPickUpOrderCode(int dispensaryPickUpOrderCode) {
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

    public String getSpecialCommnets() {
        return specialCommnets;
    }

    public void setSpecialCommnets(String specialCommnets) {
        this.specialCommnets = specialCommnets;
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

    public String getPickUpBy() {
        return pickUpBy;
    }

    public void setPickUpBy(String pickUpBy) {
        this.pickUpBy = pickUpBy;
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

}

