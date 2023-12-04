package com.kiss.carrentalsystem.dto;

import com.kiss.carrentalsystem.entity.Car;
import com.kiss.carrentalsystem.entity.User;

import java.util.Date;

public class BookingDTO {
    private Date bookingStartDate;
    private Date bookingEndDate;
    private String bookingId;
    private User user;
    private Car car;

    public BookingDTO() {
    }

    public BookingDTO(Car car, User user, String bookingId, Date bookingStartDate, Date bookingEndDate) {
        this.car = car;
        this.user = user;
        this.bookingId = bookingId;
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

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

}
