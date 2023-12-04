
package com.kiss.carrentalsystem.controller;

import com.kiss.carrentalsystem.dto.BookingDTO;
import com.kiss.carrentalsystem.service.PDFGenerator;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class PDFExportController {

    private final PDFGenerator decoratedPDFGenerator;

    @Autowired
    public PDFExportController(PDFGenerator decoratedPDFGenerator) {
        this.decoratedPDFGenerator = decoratedPDFGenerator;
    }

    @GetMapping("/pdf/generate")
    public void generatePDF(HttpServletResponse response, BookingDTO bookingDTO) throws IOException {
        this.decoratedPDFGenerator.generateBookingPDF(response, bookingDTO);
    }
}


