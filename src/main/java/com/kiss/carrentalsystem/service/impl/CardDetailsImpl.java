package com.kiss.carrentalsystem.service.impl;

import com.kiss.carrentalsystem.dto.CardDetailsDTO;
import com.kiss.carrentalsystem.entity.CardDetails;
import com.kiss.carrentalsystem.repo.CardDetailsRepo;
import com.kiss.carrentalsystem.response.DefaultResponse;
import com.kiss.carrentalsystem.service.CardDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardDetailsImpl implements CardDetailsService {

    @Autowired
    private CardDetailsRepo cardDetailsRepo;

    // This is the method to add new Card Details
    @Override
    public DefaultResponse addCard(CardDetailsDTO cardDetailsDTO) {
        // This creates a new CardDetails entity from the CardDetailsDTO
        CardDetails cardDetails = new CardDetails(
                cardDetailsDTO.getCardNumber(),
                cardDetailsDTO.getCardHolder(),
                cardDetailsDTO.getExpirationMonth(),
                cardDetailsDTO.getExpirationYear(),
                cardDetailsDTO.getCvc()
        );
        // This saves the card details to the database using the CardDetailsRepo
        cardDetailsRepo.save(cardDetails);
        return new DefaultResponse("Card added Successfully", true);
    }

    // This is the method to delete card details
    @Override
    public DefaultResponse deleteCard(CardDetailsDTO cardDetailsDTO) {
        CardDetails cardDetails2 = cardDetailsRepo.findByCardNumber(cardDetailsDTO.getCardNumber());
        if (cardDetails2 != null) {
            cardDetailsRepo.delete(cardDetails2);
            return new DefaultResponse("Card details deleted Successfully", true);
        } else {
            return new DefaultResponse("Card details were not deleted", false);
        }
    }
}
