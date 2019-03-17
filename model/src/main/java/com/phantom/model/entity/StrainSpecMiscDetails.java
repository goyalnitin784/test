package com.phantom.model.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "strain_spec_misc_details")
public class StrainSpecMiscDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "strain_id")
    private int strainId;

    @Column(name = "variation")
    private String variation;

    @Column(name = "difficulty")
    private String difficulty;

    @Column(name = "flower_period")
    private String flowerPeriod;

    @Column(name = "grow_height")
    private String growHeight;

    @Column(name = "grow_yield")
    private String growYield;

    @Column(name = "environment")
    private String environment;

    @Column(name = "breeder")
    private String breeder;

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

    public String getVariation() {
        return variation;
    }

    public void setVariation(String variation) {
        this.variation = variation;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getFlowerPeriod() {
        return flowerPeriod;
    }

    public void setFlowerPeriod(String flowerPeriod) {
        this.flowerPeriod = flowerPeriod;
    }

    public String getGrowHeight() {
        return growHeight;
    }

    public void setGrowHeight(String growHeight) {
        this.growHeight = growHeight;
    }

    public String getGrowYield() {
        return growYield;
    }

    public void setGrowYield(String growYield) {
        this.growYield = growYield;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getBreeder() {
        return breeder;
    }

    public void setBreeder(String breeder) {
        this.breeder = breeder;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
