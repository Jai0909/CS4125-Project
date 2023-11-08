package com.kiss.carrentalsystem.entity;

import jakarta.persistence.*;
@Entity
@Table(name="Payment") //todo check table name
public class CardDetails {
    @Id
    @Column(name="card_no", length = 16) //todo adjust names and lengths to fit
    private int cardNumber;
    @Column(name="card_holder", length = 255)
    private String cardHolder;
    @Column(name="exp_month", length = 2)
    private int expirationMonth;
    @Column(name="exp_year", length = 2)
    private int expirationYear;
    @Column(name="cvv", length = 3)
    private int cvc;


    public CardDetails() {
    }

    public CardDetails(int cardNumber, String cardHolder, int expirationMonth, int expirationYear, int cvc) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
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

    public int getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(int expirationYear) {
        this.expirationYear = expirationYear;
    }

    public int getCvc() {
        return cvc;
    }

    public void setCvc(int cvc) {
        this.cvc = cvc;
    }
}