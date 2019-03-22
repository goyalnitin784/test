package com.phantom.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dispensary_gallery")
public class DispensaryGallery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "dispensary_id")
    private int dispensaryId;

    @Column(name = "is_active")
    private int isActive;

    @Column(name = "picture_path")
    private String picturePath;

    @Column(name = "created_on")
    private Date createdOn;

    @Column(name = "uuid")
    private String uuid;

    @Column(name = "added_on")
    private Date addedOn;

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

    public int getIsActive() {
        return isActive;
    }

    public void setIsActive(int isActive) {
        this.isActive = isActive;
    }

    public String getPicturePath() {
        return picturePath;
    }

    public void setPicturePath(String picturePath) {
        this.picturePath = picturePath;
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

    public Date getAddedOn() {
        return addedOn;
    }

    public void setAddedOn(Date addedOn) {
        this.addedOn = addedOn;
    }
}

