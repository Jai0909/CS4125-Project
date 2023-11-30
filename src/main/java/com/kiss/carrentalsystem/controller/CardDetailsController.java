package com.kiss.carrentalsystem.controller;

import com.kiss.carrentalsystem.dto.CardDetailsDTO;
import com.kiss.carrentalsystem.response.DefaultResponse;
import com.kiss.carrentalsystem.service.CardDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("user")
public class CardDetailsController {

    @Autowired
    private CardDetailsService cardDetailsService;

    @PostMapping(path = "/saveCardDetails")
    public DefaultResponse saveCardDetails(@RequestBody CardDetailsDTO cardDetailsDTO)
    {
        return cardDetailsService.addCard(cardDetailsDTO);
    }

    @PostMapping(path = "/deleteCardDetails")
    public DefaultResponse deleteCardDetails(@RequestBody CardDetailsDTO cardDetailsDTO)
    {
        return cardDetailsService.deleteCard(cardDetailsDTO);
    }
}
