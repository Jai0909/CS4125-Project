package com.kiss.carrentalsystem.controller;

import com.kiss.carrentalsystem.dto.BookingDTO;
import com.kiss.carrentalsystem.response.DefaultResponse;
import com.kiss.carrentalsystem.service.BookingService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kiss.carrentalsystem.service.Impl.BasePDFGenerator;

import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("booking")
public class BookingController {
    @Autowired
    private BookingService bookingService;

    @Autowired
    private BasePDFGenerator pdfGeneratorService;

    @Transactional
    @PostMapping(path = "/addBooking")
        public ResponseEntity<DefaultResponse> addBooking(@RequestBody BookingDTO bookingDTO, HttpServletResponse response)
    {
        DefaultResponse defaultResponse = bookingService.addBooking(bookingDTO);
          
          PDFExportController pdfcontroller = new PDFExportController(pdfGeneratorService);
        if (defaultResponse.isSuccess()) {
            try {
                pdfcontroller.generatePDF(response, bookingDTO);
            } catch (IOException e) {
                e.printStackTrace(); // Handle exception appropriately
            }
        }
          
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
