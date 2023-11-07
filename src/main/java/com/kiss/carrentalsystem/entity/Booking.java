package com.kiss.carrentalsystem.entity;
import org.springframework.data.annotation.Id;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Booking") //todo check table name
public class Booking {
    @Id
    @Column(name = "car", length = 255) //todo adjust names and lengths to fit
    private String car;
    @Column(name = "user", length = 255)
    private String user;
    @Column(name = "bookingStartDate", length = 255)
    private Date bookingStartDate;
    @Column(name = "bookingEndDate", length = 255)
    private Date bookingEndDate;
    @jakarta.persistence.Id
    private Long id;

    public Booking() {
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

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}