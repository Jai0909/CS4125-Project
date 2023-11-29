package com.kiss.carrentalsystem.entity;

public interface PaymentState {
    void addBalance(User user, double amount);
    void removeBalance(User user, double amount);
}
