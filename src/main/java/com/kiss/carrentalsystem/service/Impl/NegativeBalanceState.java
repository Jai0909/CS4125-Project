package com.kiss.carrentalsystem.service.Impl;

import com.kiss.carrentalsystem.response.DefaultResponse;
import com.kiss.carrentalsystem.service.PaymentState;
import com.kiss.carrentalsystem.entity.User;
import com.kiss.carrentalsystem.repo.CardDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NegativeBalanceState implements PaymentState {

    @Autowired
    private CardDetailsRepo cardDetailsRepo;

    private CardDetailsImpl cardDetailsImpl;
    @Override
    public DefaultResponse addBalance(User user, double amount) {
            user.setBalance((float) (user.getBalance() + amount));
            // change to positive balance state if balance becomes positive
            if (user.getBalance() >= 0) {
                user.setState(new PositiveBalanceState());
                user.setStateString("positive");
            }
            return new DefaultResponse("Money added to Balance successfully", true);
    }

    @Override
    public DefaultResponse removeBalance(User user, double amount) {
        return new DefaultResponse("Cannot remove balance. Balance is negative.", false);
    }
}

