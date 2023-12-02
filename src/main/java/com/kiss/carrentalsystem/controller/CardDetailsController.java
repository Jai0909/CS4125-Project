package com.kiss.carrentalsystem.controller;

import com.kiss.carrentalsystem.dto.CardDetailsDTO;
import com.kiss.carrentalsystem.response.DefaultResponse;
import com.kiss.carrentalsystem.service.CardDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("card")
public class CardDetailsController {

    @Autowired
    private CardDetailsService cardDetailsService;

    @PostMapping(path = "/saveCardDetails")
    public ResponseEntity<?> saveCardDetails(@RequestBody CardDetailsDTO cardDetailsDTO)
    {
        DefaultResponse defaultResponse =  cardDetailsService.addCard(cardDetailsDTO);
        return ResponseEntity.ok(defaultResponse);
    }

    @PostMapping(path = "/deleteCardDetails")
    public ResponseEntity<?> deleteCardDetails(@RequestBody CardDetailsDTO cardDetailsDTO)
    {
        DefaultResponse defaultResponse =  cardDetailsService.deleteCard(cardDetailsDTO);
        return ResponseEntity.ok(defaultResponse);
    }
}
