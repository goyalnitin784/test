package com.phantom.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "strain_flavours")
public class StrainFlavours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "strain_id")
    private int strainId;

    @Column(name = "strain_flavour_master_id")
    private String StrainFlavourMasterId;

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

    public String getStrainFlavourMasterId() {
        return StrainFlavourMasterId;
    }

    public void setStrainFlavourMasterId(String strainFlavourMasterId) {
        StrainFlavourMasterId = strainFlavourMasterId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}

