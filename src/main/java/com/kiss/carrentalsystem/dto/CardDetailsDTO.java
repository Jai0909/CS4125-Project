package com.kiss.carrentalsystem.dto;

import jakarta.persistence.Column;

public class CardDetailsDTO {

    private int cardNumber;
    private String cardHolder;
    private int expirationMonth;
    private int expirationYear;
    private int cvc;

    public CardDetailsDTO() {

    }

    public CardDetailsDTO(int cardNumber, String cardHolder, int expirationMonth, int expirationYear, int cvc) {
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
