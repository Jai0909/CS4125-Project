package com.kiss.carrentalsystem.Dto;

public class UserDTO {
    private String email;
    private String name;
    private String password;
    private String phoneno;
    private String gender;
    private String address;

    public UserDTO() {
    }

    public UserDTO(String email, String name, String password, String phoneno, String gender, String address) {
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