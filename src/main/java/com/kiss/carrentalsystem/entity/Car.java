package com.kiss.carrentalsystem.entity;
import org.springframework.data.annotation.Id;

import jakarta.persistence.*;
@Entity
@Table(name="car") //todo check table name
public class Car {
    @Id
    @Column(name="makeAndModel", length = 255) //todo adjust names and lengths to fit
    private String makeAndModel;
    @Column(name="licencePlate", length = 255)
    private String licencePlate;
    @Column(name="milage", length = 255)
    private int milage;
    @Column(name="vehicleType", length = 255)
    private String vehicleType;
    @Column(name="damaged", length = 255)
    private boolean damaged;
    @Column(name="basePrice", length = 255)
    private float basePrice;


    public Car() {
    }

    public Car(String makeAndModel, String licencePlate, int milage, String vehicleType, boolean damaged, float basePrice) {
        this.makeAndModel = makeAndModel;
        this.licencePlate = licencePlate;
        this.milage = milage;
        this.vehicleType = vehicleType;
        this.damaged = damaged;
        this.basePrice = basePrice;
    }

    public String getMakeAndModel() {
        return makeAndModel;
    }

    public void setMakeAndModel(String makeAndModel) {
        this.makeAndModel = makeAndModel;
    }

    public String getLicencePlate() {
        return licencePlate;
    }

    public void setLicencePlate(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public int getMilage() {
        return milage;
    }

    public void setMilage(int milage) {
        this.milage = milage;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public boolean isDamaged() {
        return damaged;
    }

    public void setDamaged(boolean damaged) {
        this.damaged = damaged;
    }

    public float getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(float basePrice) {
        this.basePrice = basePrice;
    }
}
