package com.phantom.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dispensary_pick_up_order_details")
public class DispensaryPickUpOrderDetails {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "dispensary_pick_up_id")
    private int dispensaryPickUpId;

    @Column(name = "strain_name")
    private String strainName;

    @Column(name = "Quantity")
    private String quantity;

    @Column(name = "price")
    private String price;

    @Column(name = "created_on")
    private Date createdOn;

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

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}

