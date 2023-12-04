package com.kiss.carrentalsystem.entity;

import com.kiss.carrentalsystem.response.DefaultResponse;
import com.kiss.carrentalsystem.service.impl.NegativeBalanceState;
import com.kiss.carrentalsystem.service.impl.PositiveBalanceState;
import com.kiss.carrentalsystem.service.PaymentState;
import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name="User")
public class User {
    @Id
    @Column(name="email", length = 255)
    private String email;
    @Column(name="name", length = 255)
    private String name;
    @Column(name="password", length = 255)
    private String password;
    @Column(name="phoneno", length = 255)
    private String phoneNo;
    @Column(name="address", length = 255)
    private String address;
    @Column(name="user_milage")
    private int userMilage;
    @Column(name="date_of_birth")
    private String dateOfBirth;
    @OneToMany(mappedBy = "user")
    private List<Booking> bookings;
    @Column(name="is_admin")
    private boolean isAdmin;
    @Column(name="balance")
    private float balance;
    @Transient // speciefies that it shouldnt be in db
    private PaymentState state;

    @Column(name="state")
    private String stateString;

    public User(String email, String name, String password, String phoneNo, String address, int userMilage, String dateOfBirth, boolean isAdmin, float balance) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.phoneNo = phoneNo;
        this.address = address;
        this.userMilage = userMilage;
        this.dateOfBirth = dateOfBirth;
        this.isAdmin = isAdmin;
        this.balance = balance;
        if (stateString == null || stateString.equals("positive")) {
            this.state = new PositiveBalanceState();
            stateString = "positive";
        } else {
            this.state = new NegativeBalanceState();
        }
    }

    public User(String email, String name, String password, String phoneNo, String address, int userMilage, String dateOfBirth) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.phoneNo = phoneNo;
        this.address = address;
        this.userMilage = userMilage;
        this.dateOfBirth = dateOfBirth;
        if (stateString.equals(null) || stateString.equals("positive")) {
            this.state = new PositiveBalanceState();
            stateString = "positive";
        } else {
            this.state = new NegativeBalanceState();
        }
    }

    public User() {
    }

    public int getUserMilage() {
        return userMilage;
    }

    public void setUserMilage(int userMilage) {
        this.userMilage = userMilage;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public DefaultResponse addBalance(double amount) {
        if (stateString == null || stateString.equals("positive")) {
            this.state = new PositiveBalanceState();
            stateString = "positive";
        } else {
            this.state = new NegativeBalanceState();
        }
        return state.addBalance(this, amount);
    }

    public DefaultResponse removeBalance(double amount) {
        if (stateString == null || stateString.equals("positive")) {
            this.state = new PositiveBalanceState();
            stateString = "positive";
        } else {
            this.state = new NegativeBalanceState();
        }
        return state.removeBalance(this, amount);
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public void setState(PaymentState state) {
        this.state = state;
    }

    public String getStateString() {
        return stateString;
    }

    public void setStateString(String stateString) {
        this.stateString = stateString;
    }
}

