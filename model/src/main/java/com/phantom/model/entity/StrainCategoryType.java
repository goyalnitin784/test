package com.phantom.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "strain_category_type")
public class StrainCategoryType {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private long id;

    @Column(name = "strain_category_type")
    private String strainCategoryType;

    @Column(name = "description")
    private String description;

    @Column(name = "created_on")
    private Date createdOn;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStrainCategoryType() {
        return strainCategoryType;
    }

    public void setStrainCategoryType(String strainCategoryType) {
        this.strainCategoryType = strainCategoryType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

}

