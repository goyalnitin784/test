package com.phantom.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "strain_effects")
public class StrainEffects {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "strain_id")
    private int strainId;

    @Column(name = "strain_effects_master_id")
    private String strainEffectsMasterId;

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

    public String getStrainEffectsMasterId() {
        return strainEffectsMasterId;
    }

    public void setStrainEffectsMasterId(String strainEffectsMasterId) {
        this.strainEffectsMasterId = strainEffectsMasterId;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

}
