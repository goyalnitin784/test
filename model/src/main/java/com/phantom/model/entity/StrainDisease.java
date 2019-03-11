package com.phantom.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "strain_disease")
public class StrainDisease {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "strain_id")
    private int strainId;

    @Column(name = "strain_disease_cure_master_id")
    private String strainDiseaseCureMasterId;

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

    public String getStrainDiseaseCureMasterId() {
        return strainDiseaseCureMasterId;
    }

    public void setStrainDiseaseCureMasterId(String strainDiseaseCureMasterId) {
        this.strainDiseaseCureMasterId = strainDiseaseCureMasterId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
