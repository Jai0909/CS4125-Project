package com.kiss.carrentalsystem.service.Impl;

import com.kiss.carrentalsystem.dto.CardDetailsDTO;
import com.kiss.carrentalsystem.entity.CardDetails;
import com.kiss.carrentalsystem.response.DefaultResponse;
import com.kiss.carrentalsystem.service.CardDetailsService;
import com.kiss.carrentalsystem.service.PaymentState;
import com.kiss.carrentalsystem.entity.User;
import com.kiss.carrentalsystem.repo.CardDetailsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PositiveBalanceState implements PaymentState {

    @Override
    public DefaultResponse addBalance(User user, double amount) {
            user.setBalance((float) (user.getBalance() + amount)); //todo there is no checking to see if a user has added a card.
            return new DefaultResponse("Money added to Balance successfully", true);
    }

    @Override
    public DefaultResponse removeBalance(User user, double amount) {
        if (user.getBalance() + 100 >= amount) { // +100 so that a user can have -100EUR so that they can have a negative balance
            user.setBalance((float) (user.getBalance() - amount));
            // change to negative balance state if balance becomes negative
            return new DefaultResponse("Money removed from Balance successfully", true);
        } else {
            if (user.getBalance() < 0) { //todo each time it is called the state resets.
                user.setState(new NegativeBalanceState());
            }
            return new DefaultResponse("Money was not removed from Balance, insufficient funds", false);
        }
    }

}


//    @Override
//    public DefaultResponse addBalance(User user, double amount) {
//        if (checkIfCardHolderExists(user.getName())) {
//            user.setBalance((float) (user.getBalance() + amount));
//            return new DefaultResponse("Money added to Balance successfully", true);
//        } else {
//            return new DefaultResponse("Money was not added to Balance successfully", true); //todo change message to be about no card
//        }
//    }



//    private boolean checkIfCardHolderExists(String cardHolderName) {
//        CardDetails cardDetails2 = cardDetailsRepo.findByCardNumber(cardDetailsDTO.getCardNumber());
//        System.out.println(cardDetails2.getCardHolder());
//        return cardDetailsRepo.findByCardHolder(cardHolderName) != null;
//    }
