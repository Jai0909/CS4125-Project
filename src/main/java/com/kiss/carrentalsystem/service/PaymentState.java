package com.kiss.carrentalsystem.service;

import com.kiss.carrentalsystem.entity.User;
import com.kiss.carrentalsystem.response.DefaultResponse;

public interface PaymentState {
    DefaultResponse addBalance(User user, double amount);
    DefaultResponse removeBalance(User user, double amount);
}
