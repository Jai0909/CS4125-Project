package com.kiss.carrentalsystem.Entity;
import org.springframework.data.annotation.Id;

import jakarta.persistence.*;
@Entity
@Table(name="user")
public class User {
    @Id
    @Column(name="email", length = 255)
    private String email;
    @Column(name="name", length = 255)
    private String name;
    @Column(name="password", length = 255)
    private String password;
    @Column(name="phoneno", length = 255)
    private String phoneno;
    @Column(name="gender", length = 255)
    private String gender;
    @Column(name="address", length = 255)
    private String address;


    public User() {
    }

    public User(String email, String name, String password, String phoneno, String gender, String address) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.phoneno = phoneno;
        this.gender = gender;
        this.address = address;
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

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

