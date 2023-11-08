package com.kiss.carrentalsystem.entity;

import jakarta.persistence.*;
@Entity
@Table(name="Car") //todo check table name
public class Car {
    @Id
    @Column(name="make_and_model", length = 255) //todo adjust names and lengths to fit
    private String makeAndModel;
    @Column(name="reg_no", length = 255)
    private String licencePlate;
    @Column(name="milage", length = 255)
    private int milage;
    @Column(name="type", length = 255)
    private String vehicleType;
    @Column(name="damages", length = 255)
    private boolean damaged;
    @Column(name="price", length = 255)
    private float basePrice;
    @Column(name="availability", length = 255)
    private boolean availability;


    public Car() {
    }

    public Car(String makeAndModel, String licencePlate, int milage, String vehicleType, boolean damaged, float basePrice, boolean availability) {
        this.makeAndModel = makeAndModel;
        this.licencePlate = licencePlate;
        this.milage = milage;
        this.vehicleType = vehicleType;
        this.damaged = damaged;
        this.basePrice = basePrice;
        this.availability = availability;
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

    public boolean isAvailability() {
        return availability;
    }

    public void setAvailability(boolean availability) {
        this.availability = availability;
    }
}
