package com.phantom.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Newsletter_subscription")
public class NewsletterSubscription {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "email")
    private String email;

    @Column(name = "subscribed")
    private boolean isSubscribed;

    @Column(name = "subscribed_on")
    private Date subscribedOn;

    @Column(name = "unsubscribed_on")
    private Date unSubscribeOn;

    @Column(name = "unsubscription_reason")
    private String unSubscriptionReason;

    @Column(name = "created_on")
    private Date createdOn;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isSubscribed() {
        return isSubscribed;
    }

    public void setSubscribed(boolean subscribed) {
        isSubscribed = subscribed;
    }

    public Date getSubscribedOn() {
        return subscribedOn;
    }

    public void setSubscribedOn(Date subscribedOn) {
        this.subscribedOn = subscribedOn;
    }

    public Date getUnSubscribeOn() {
        return unSubscribeOn;
    }

    public void setUnSubscribeOn(Date unSubscribeOn) {
        this.unSubscribeOn = unSubscribeOn;
    }

    public String getUnSubscriptionReason() {
        return unSubscriptionReason;
    }

    public void setUnSubscriptionReason(String unSubscriptionReason) {
        this.unSubscriptionReason = unSubscriptionReason;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

