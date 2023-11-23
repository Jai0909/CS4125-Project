package com.kiss.carrentalsystem.dto;

import java.util.Date;

public class BookingDTO {
    private String car;
    private String user;
    private Date bookingStartDate;
    private Date bookingEndDate;
    private String bookingId;

    public BookingDTO() {
    }

    public BookingDTO(String car, String user, String bookingId, Date bookingStartDate, Date bookingEndDate) {
        this.car = car;
        this.user = user;
        this.bookingId = bookingId;
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

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String booking_id) {
        this.bookingId = booking_id;
    }
}
