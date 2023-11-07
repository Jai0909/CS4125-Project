package com.kiss.carrentalsystem.entity;
import org.springframework.data.annotation.Id;

import jakarta.persistence.*;

import java.util.Date;

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
    private String phoneno;
    @Column(name="address", length = 255)
    private String address;
    @Column(name="userMilage")
    private int userMilage;
    @Column(name="dateOfBirth")
    private Date dateOfBirth;
    @jakarta.persistence.Id
    private Long id;

    public User(String email, String name, String password, String phoneno, String address, int userMilage, Date dateOfBirth) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.phoneno = phoneno;
        this.address = address;
        this.userMilage = userMilage;
        this.dateOfBirth = dateOfBirth;
    }

    public User() {
    }

    public int getUserMilage() {
        return userMilage;
    }

    public void setUserMilage(int userMilage) {
        this.userMilage = userMilage;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
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

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }



    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}

