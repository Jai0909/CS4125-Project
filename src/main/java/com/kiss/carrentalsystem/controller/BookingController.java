package com.kiss.carrentalsystem.controller;

import com.kiss.carrentalsystem.dto.BookingDTO;
import com.kiss.carrentalsystem.response.UserResponse;
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
    public UserResponse addBooking(@RequestBody BookingDTO bookingDTO)
    {
        return bookingService.addBooking(bookingDTO);
    }

//    public ResponseEntity<?> addBooking(@RequestBody BookingDTO bookingDTO)
//    {
//        UserResponse bookingResponse = bookingService.addBooking(bookingDTO);
//        return ResponseEntity.ok(bookingResponse);
//    }

    @PostMapping(path = "/cancelBooking")
    public ResponseEntity<?> cancelBooking(@RequestBody BookingDTO bookingDTO)
    {
        UserResponse bookingResponse = bookingService.cancelBooking(bookingDTO);
        return ResponseEntity.ok(bookingResponse);
    }
}
