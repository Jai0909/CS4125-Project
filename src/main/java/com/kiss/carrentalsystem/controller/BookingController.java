package com.kiss.carrentalsystem.controller;

import com.kiss.carrentalsystem.dto.BookingDTO;
import com.kiss.carrentalsystem.response.DefaultResponse;
import com.kiss.carrentalsystem.service.BookingService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @Transactional
    @PostMapping(path = "/addBooking")
    public ResponseEntity<DefaultResponse> addBooking(@RequestBody BookingDTO bookingDTO)
    {
        DefaultResponse defaultResponse = bookingService.addBooking(bookingDTO);
        return ResponseEntity.ok(defaultResponse);
    }

    @PostMapping(path = "/cancelBooking",
            consumes = {
            MediaType.APPLICATION_JSON_VALUE
    },
            produces = {
                    MediaType.APPLICATION_JSON_VALUE
            })
    public ResponseEntity<?> cancelBooking(@RequestBody BookingDTO bookingDTO)
    {
        DefaultResponse bookingResponse = bookingService.cancelBooking(bookingDTO);
        return ResponseEntity.ok(bookingResponse);
    }


}
