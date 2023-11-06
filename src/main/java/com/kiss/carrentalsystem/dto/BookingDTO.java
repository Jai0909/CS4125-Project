package com.kiss.carrentalsystem.dto;

import com.kiss.carrentalsystem.entity.Car;
import com.kiss.carrentalsystem.entity.User;
import jakarta.persistence.Column;

import java.util.Date;

public class BookingDTO {
    private Car car;
    private User user;
    private Date bookingStartDate;
    private Date bookingEndDate;

    public BookingDTO() {
    }

    public BookingDTO(Car car, User user, Date bookingStartDate, Date bookingEndDate) {
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
