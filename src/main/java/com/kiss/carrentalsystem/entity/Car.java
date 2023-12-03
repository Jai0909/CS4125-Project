package com.kiss.carrentalsystem.entity;

import jakarta.persistence.*;
@Entity
@Table(name="Car") //todo check table name
public class Car {

    @Column(name="makeModel", length = 255) //todo adjust names and lengths to fit
    private String makeModel;
    @Id
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
    @Column(name="weight", length = 10)
    private int weight;

    @OneToOne(mappedBy = "car")
    private Booking booking;

    public Car() {
    }

    public Car(String makeAndModel, String licencePlate, int milage, String vehicleType, boolean damaged, float basePrice, boolean availability, int weight) {
        this(makeAndModel, licencePlate, milage, vehicleType, damaged, basePrice,availability);
        this.weight = weight;
    }
    public Car(String makeModel, String licencePlate, int milage, String vehicleType, boolean damaged, float basePrice, boolean availability) {
        this.makeModel = makeModel;
        this.licencePlate = licencePlate;
        this.milage = milage;
        this.vehicleType = vehicleType;
        this.damaged = damaged;
        this.basePrice = basePrice;
        this.availability = availability;

    }
    public String getMakeModel() {
        return makeModel;
    }

    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
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

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

}
