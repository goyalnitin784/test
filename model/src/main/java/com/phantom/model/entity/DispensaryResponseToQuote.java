package com.phantom.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dispensary_response_to_quote")
public class DispensaryResponseToQuote {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "quote_qequest_sent_to_id")
    private int quoteRequestSentToId;

    @Column(name = "price")
    private int price;

    @Column(name = "price_valid_till")
    private String priceValidTill;

    @Column(name = "strain_details")
    private String strainDetails;

    @Column(name = "user_rating")
    private int userRating;

    @Column(name = "special_comments")
    private String specialComments;

    @Column(name = "created_on")
    private Date createdOn;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getQuoteRequestSentToId() {
        return quoteRequestSentToId;
    }

    public void setQuoteRequestSentToId(int quoteRequestSentToId) {
        this.quoteRequestSentToId = quoteRequestSentToId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPriceValidTill() {
        return priceValidTill;
    }

    public void setPriceValidTill(String priceValidTill) {
        this.priceValidTill = priceValidTill;
    }

    public String getStrainDetails() {
        return strainDetails;
    }

    public void setStrainDetails(String strainDetails) {
        this.strainDetails = strainDetails;
    }

    public int getUserRating() {
        return userRating;
    }

    public void setUserRating(int userRating) {
        this.userRating = userRating;
    }

    public String getSpecialComments() {
        return specialComments;
    }

    public void setSpecialComments(String specialComments) {
        this.specialComments = specialComments;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}

