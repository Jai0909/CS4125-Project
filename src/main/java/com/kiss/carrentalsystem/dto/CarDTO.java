package com.kiss.carrentalsystem.dto;

import jakarta.persistence.Column;

public class CarDTO {

    private String makeAndModel;
    private String licencePlate;
    private int milage;
    private String vehicleType;
    private boolean damaged;
    private float basePrice;
    private boolean availability;

    public CarDTO() {
    }

    public CarDTO(String makeAndModel, String licencePlate, int milage, String vehicleType, boolean damaged, float basePrice, boolean availability) {
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
