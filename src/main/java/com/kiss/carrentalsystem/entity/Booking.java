package com.kiss.carrentalsystem.entity;
import org.springframework.data.annotation.Id;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="booking") //todo check table name
public class Booking {
    @Id
    @Column(name = "car", length = 255) //todo adjust names and lengths to fit
    private Car car;
    @Column(name = "user", length = 255)
    private User user;
    @Column(name = "bookingStartDate", length = 255)
    private Date bookingStartDate;
    @Column(name = "bookingEndDate", length = 255)
    private Date bookingEndDate;

    public Booking() {
    }

    public Booking(Car car, User user, Date bookingStartDate, Date bookingEndDate) {
        this.car = car;
        this.user = user;
        this.bookingStartDate = bookingStartDate;
        this.bookingEndDate = bookingEndDate;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
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
}