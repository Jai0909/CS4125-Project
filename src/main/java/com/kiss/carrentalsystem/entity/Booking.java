package com.kiss.carrentalsystem.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Booking")
public class Booking {

    @Id
    @Column(name = "booking_id", length = 255)
    private String bookingId;
    @Column(name = "start_date", length = 255)
    private Date bookingStartDate;
    @Column(name = "end_date", length = 255)
    private Date bookingEndDate;

    @ManyToOne
    @JoinColumn(name = "email", referencedColumnName = "email", insertable = false, updatable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "reg_no", referencedColumnName = "reg_no", insertable = false, updatable = false)
    private Car car;

    public Booking(User user, Car car, String bookingId, Date bookingStartDate, Date bookingEndDate) {
        this.user = user;
        this.car = car;
        this.bookingStartDate = bookingStartDate;
        this.bookingEndDate = bookingEndDate;
        this.bookingId = bookingId;
    }
    public Booking() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
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