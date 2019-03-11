package com.phantom.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "testimonials")
public class Testimonials {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "description")
    private String description;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "updated_on")
    private Date UpdatedOn;

    @Column(name = "display_on_home_page")
    private boolean displayOnHomePage;

    @Column(name = "created_on")
    private Date createdOn;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Date getUpdatedOn() {
        return UpdatedOn;
    }

    public void setUpdatedOn(Date updatedOn) {
        UpdatedOn = updatedOn;
    }

    public boolean isDisplayOnHomePage() {
        return displayOnHomePage;
    }

    public void setDisplayOnHomePage(boolean displayOnHomePage) {
        this.displayOnHomePage = displayOnHomePage;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}

