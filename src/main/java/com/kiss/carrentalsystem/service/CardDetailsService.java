package com.kiss.carrentalsystem.service;

import com.kiss.carrentalsystem.dto.CardDetailsDTO;
import com.kiss.carrentalsystem.response.DefaultResponse;

public interface CardDetailsService {

    DefaultResponse addCard(CardDetailsDTO cardDetailsDTO);

    DefaultResponse deleteCard(CardDetailsDTO cardDetailsDTO);
}
