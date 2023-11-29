package com.kiss.carrentalsystem.entity;

public interface PaymentState {
    void addBalance(PaymentContext context, double amount);
    void removeBalance(PaymentContext context, double amount);
}
