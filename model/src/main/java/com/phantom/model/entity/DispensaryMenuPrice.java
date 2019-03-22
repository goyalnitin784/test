package com.phantom.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dispensary_menu_price")
public class DispensaryMenuPrice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "Dispensary_menu_id")
    private int dispensaryMenuId;

    @Column(name = "product_price")
    private String productPrice;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "currency")
    private String currency;

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

    public int getDispensaryMenuId() {
        return dispensaryMenuId;
    }

    public void setDispensaryMenuId(int dispensaryMenuId) {
        this.dispensaryMenuId = dispensaryMenuId;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
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

