package com.kiss.carrentalsystem.service.Impl;

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
    @Override
    public DefaultResponse addCard(CardDetailsDTO cardDetailsDTO) {
        CardDetails cardDetails = new CardDetails(
                cardDetailsDTO.getCardNumber(),
                cardDetailsDTO.getCardHolder(),
                cardDetailsDTO.getExpirationMonth(),
                cardDetailsDTO.getExpirationYear(),
                cardDetailsDTO.getCvc()
        );
        cardDetailsRepo.save(cardDetails);
        return new DefaultResponse("Card added Successfully", true);
    }
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
