package com.kiss.carrentalsystem.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Booking") //todo check table name
public class Booking {
    @Id
    @Column(name = "reg_no", length = 255) //todo adjust names and lengths to fit
    private String car;
    @Column(name = "email", length = 255)
    private String user;
    @Column(name = "booking_id", length = 255)
    private String booking_id;
    @Column(name = "start_date", length = 255)
    private Date bookingStartDate;
    @Column(name = "end_date", length = 255)
    private Date bookingEndDate;

    public Booking() {
    }

    public Booking(String car, String user, String booking_id, Date bookingStartDate, Date bookingEndDate) {
        this.car = car;
        this.user = user;
        this.booking_id = booking_id;
        this.bookingStartDate = bookingStartDate;
        this.bookingEndDate = bookingEndDate;
    }

    public Booking(String car, String user, Date bookingStartDate, Date bookingEndDate) {
        this.car = car;
        this.user = user;
        this.bookingStartDate = bookingStartDate;
        this.bookingEndDate = bookingEndDate;
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

    public String getBooking_id() {
        return booking_id;
    }

    public void setBooking_id(String booking_id) {
        this.booking_id = booking_id;
    }
}