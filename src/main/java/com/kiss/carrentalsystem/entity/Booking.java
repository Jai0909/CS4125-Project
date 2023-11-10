package com.kiss.carrentalsystem.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Booking") //todo check table name
public class Booking {
    @Column(name = "reg_no", length = 255) //todo adjust names and lengths to fit
    private String car;
    @Column(name = "email", length = 255)
    private String user;
    @Id
    @Column(name = "booking_id", length = 255)
    private String bookingId;
    @Column(name = "start_date", length = 255)
    private Date bookingStartDate;
    @Column(name = "end_date", length = 255)
    private Date bookingEndDate;

    public Booking() {
    }

    public Booking(String car, String user, String bookingId, Date bookingStartDate, Date bookingEndDate) {
        this.car = car;
        this.user = user;
        this.bookingStartDate = bookingStartDate;
        this.bookingEndDate = bookingEndDate;
        this.bookingId = bookingId;
    }

    public String getCar() {
        return car;
    }

    public void setCar(String car) {
        this.car = car;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Date getBookingStartDate() {
        return bookingStartDate;
    }

    public void setBookingStartDate(Date bookingStartDate) {
        this.bookingStartDate = bookingStartDate;
    }

    public Date getBookingEndDate() {
        return bookingEndDate;
    }

    public void setBookingEndDate(Date bookingEndDate) {
        this.bookingEndDate = bookingEndDate;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }
}