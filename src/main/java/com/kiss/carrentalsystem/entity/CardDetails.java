package com.kiss.carrentalsystem.entity;
import org.springframework.data.annotation.Id;

import jakarta.persistence.*;
@Entity
@Table(name="cardDetails") //todo check table name
public class CardDetails {
    @Id
    @Column(name="cardNumber", length = 16) //todo adjust names and lengths to fit
    private int cardNumber;
    @Column(name="cardHolder", length = 255)
    private String cardHolder;
    @Column(name="expirationMonth", length = 2)
    private int expirationMonth;
    @Column(name="expirationDay", length = 2)
    private int expirationDay;
    @Column(name="cvc", length = 3)
    private int cvc;


    public CardDetails() {
    }

    public CardDetails(int cardNumber, String cardHolder, int expirationMonth, int expirationDay, int cvc) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expirationMonth = expirationMonth;
        this.expirationDay = expirationDay;
        this.cvc = cvc;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardHolder() {
        return cardHolder;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public int getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(int expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public int getExpirationDay() {
        return expirationDay;
    }

    public void setExpirationDay(int expirationDay) {
        this.expirationDay = expirationDay;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }
}