package com.kiss.carrentalsystem.entity;

public class PaymentContext {

    private double balance;
    private PaymentState state;

    public PaymentContext() {
        this.balance = 0.0;
        this.state = new PositiveBalanceState(this);
    }

    public void addBalance(double amount) {
        state.addBalance(this, amount);
    }

    public void removeBalance(double amount) {
        state.removeBalance(this, amount);
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setState(PaymentState state) {
        this.state = state;
    }

    public PaymentState getState() {
        return state;
    }
}
