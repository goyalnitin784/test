package com.phantom.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dispensary_pick_up_order_details")
public class DispensaryPickUpOrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "Dispensary_pick_up_order_Id")
    private int dispensaryPickUpId;

    @Column(name = "strain_name")
    private String strainName;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private int price;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "last_updated_on")
    private Date lastUpdatedOn;

    @Column(name = "uuid")
    private String uuid;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getDispensaryPickUpId() {
        return dispensaryPickUpId;
    }

    public void setDispensaryPickUpId(int dispensaryPickUpId) {
        this.dispensaryPickUpId = dispensaryPickUpId;
    }

    public String getStrainName() {
        return strainName;
    }

    public void setStrainName(String strainName) {
        this.strainName = strainName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    public void setLastUpdatedOn(Date lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}

