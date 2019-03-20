package com.phantom.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "quote_request")
public class QuoteRequestEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "location")
    private String location;

    @Column(name = "strain_details")
    private String strainDetails;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "comments")
    private String comments;

    @Column(name = "created_on")
    private Date createdOn;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getStrainDetails() {
        return strainDetails;
    }

    public void setStrainDetails(String strainDetails) {
        this.strainDetails = strainDetails;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

