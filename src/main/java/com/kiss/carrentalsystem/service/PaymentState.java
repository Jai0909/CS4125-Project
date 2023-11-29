package com.kiss.carrentalsystem.service;

import com.kiss.carrentalsystem.entity.User;

public interface PaymentState {
    void addBalance(User user, double amount);
    void removeBalance(User user, double amount);
}
