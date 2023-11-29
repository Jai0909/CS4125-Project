package com.kiss.carrentalsystem.entity;

import com.kiss.carrentalsystem.repo.CardDetailsRepo;

public class NegativeBalanceState implements PaymentState {
    private CardDetailsRepo cardDetailsRepo;
    @Override
    public void addBalance(User user, double amount) {
        if (cardDetailsRepo.findByCardHolder(user.getName()) != null) {
            user.setBalance((float) (user.getBalance() + amount));
            // change to positive balance state if balance becomes positive
            if (user.getBalance() >= 0) {
                user.setState(new PositiveBalanceState());
            }
        } else {
            //todo add a return for message saying to add card to acc.
        }
    }

    @Override
    public void removeBalance(User user, double amount) {
        System.out.println("Cannot remove balance. Balance is negative.");
        //todo add a proper return type - response or something?
    }
}

