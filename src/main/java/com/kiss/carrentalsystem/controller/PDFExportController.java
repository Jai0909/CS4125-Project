
package com.kiss.carrentalsystem.controller;

import com.kiss.carrentalsystem.dto.BookingDTO;
import com.kiss.carrentalsystem.service.PDFGenerator;
import com.kiss.carrentalsystem.service.impl.ConfirmationPDFDecorator;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class PDFExportController {

    // This is the constructor injection of the PDFGenerator service
    private final PDFGenerator pdfGeneratorService;

    @Autowired
    public PDFExportController(PDFGenerator decoratedPDFGenerator) {
        this.pdfGeneratorService = decoratedPDFGenerator;
    }

    // This Handler method generates the Receipt PDF containg the booking details
    @GetMapping("/pdf/generate")
    public void generatePDF(HttpServletResponse response, BookingDTO bookingDTO) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        // The decorator is created that adds confirmation statement of the booking to the generated Receipt PDF
        PDFGenerator decoratedPDFGenerator = new ConfirmationPDFDecorator(pdfGeneratorService);
        decoratedPDFGenerator.generateBookingPDF(response, bookingDTO);
    }
}


