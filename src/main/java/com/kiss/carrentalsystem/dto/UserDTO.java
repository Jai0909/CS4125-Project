package com.kiss.carrentalsystem.dto;


public class UserDTO {
    private String email;
    private String name;
    private String password;
    private String phoneno;
    private String address;
    private int userMilage;
    private String dateOfBirth;

    public UserDTO() {
    }

    public UserDTO(String email, String name, String password, String phoneno, String address, int userMilage, String dateOfBirth) {
        this.email = email;
        this.name = name;
        this.password = password;
        this.phoneno = phoneno;
        this.address = address;
        this.userMilage = userMilage;
        this.dateOfBirth = dateOfBirth;
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
}