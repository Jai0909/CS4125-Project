package com.kiss.carrentalsystem.controller;

import com.kiss.carrentalsystem.dto.BookingDTO;
import com.kiss.carrentalsystem.response.DefaultResponse;
import com.kiss.carrentalsystem.service.BookingService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kiss.carrentalsystem.service.Impl.BasePDFGenerator;

import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("user")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @Autowired
    private BasePDFGenerator pdfGeneratorService;

    @PostMapping(path = "/addBooking")
    public DefaultResponse addBooking(@RequestBody BookingDTO bookingDTO, HttpServletResponse response) {
        DefaultResponse bookingResponse = bookingService.addBooking(bookingDTO);

        PDFExportController pdfcontroller = new PDFExportController(pdfGeneratorService);
        if (bookingResponse.isSuccess()) {
            try {
                pdfcontroller.generatePDF(response, bookingDTO);
            } catch (IOException e) {
                e.printStackTrace(); // Handle exception appropriately
            }
        }

        return bookingResponse;
    }

    @PostMapping(path = "/cancelBooking")
    public ResponseEntity<?> cancelBooking(@RequestBody BookingDTO bookingDTO) {
        DefaultResponse bookingResponse = bookingService.cancelBooking(bookingDTO);
        return ResponseEntity.ok(bookingResponse);
    }
}
