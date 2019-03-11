package com.phantom.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "strain_gallery")
public class StrainGallery {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "strain_id")
    private int strainId;

    @Column(name = "is_active")
    private boolean isActive;

    @Column(name = "image")
    private String imagePath;

    @Column(name = "created_on")
    private Date createdOn;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getStrainId() {
        return strainId;
    }

    public void setStrainId(int strainId) {
        this.strainId = strainId;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}

