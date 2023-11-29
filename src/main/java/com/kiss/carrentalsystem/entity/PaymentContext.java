package com.kiss.carrentalsystem.entity;

public class PaymentContext {

    private PaymentState state;

    public PaymentContext() {
        this.state = new PositiveBalanceState();
    }

    public void addBalance(User user, double amount) {
        state.addBalance(user, amount);
    }

    public void removeBalance(User user, double amount) {
        state.removeBalance(user, amount);
    }

    public void setState(PaymentState state) {
        this.state = state;
    }
}
