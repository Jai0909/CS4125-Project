package com.kiss.carrentalsystem.controller;

import com.kiss.carrentalsystem.dto.BookingDTO;
import com.kiss.carrentalsystem.response.DefaultResponse;
import com.kiss.carrentalsystem.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("user")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @PostMapping(path = "/addBooking")
    public DefaultResponse addBooking(@RequestBody BookingDTO bookingDTO)
    {
        return bookingService.addBooking(bookingDTO);
    }

    @PostMapping(path = "/cancelBooking")
    public ResponseEntity<?> cancelBooking(@RequestBody BookingDTO bookingDTO)
    {
        DefaultResponse bookingResponse = bookingService.cancelBooking(bookingDTO);
        return ResponseEntity.ok(bookingResponse);
    }
}
