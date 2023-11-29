package com.kiss.carrentalsystem.service.Impl;

import com.kiss.carrentalsystem.service.PaymentState;
import com.kiss.carrentalsystem.entity.User;
import com.kiss.carrentalsystem.repo.CardDetailsRepo;

public class PositiveBalanceState implements PaymentState {
    private CardDetailsRepo cardDetailsRepo;

    @Override
    public void addBalance(User user, double amount) {
        if (cardDetailsRepo.findByCardHolder(user.getName()) != null) {
            user.setBalance((float) (user.getBalance() + amount));
        } else {
            //todo add a return for message saying to add card to acc.
        }
    }

    @Override
    public void removeBalance(User user, double amount) {
        if (user.getBalance() >= amount) {
            user.setBalance((float) (user.getBalance() - amount));
            // change to negative balance state if balance becomes negative
            if (user.getBalance() < 0) {
                user.setState(new NegativeBalanceState());
            }
            //todo removed balance successfully message
        } else {
            //todo Remove from balance failed insufficient funds.
        }
    }

}