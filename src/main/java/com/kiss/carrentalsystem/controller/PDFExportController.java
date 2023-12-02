
package com.kiss.carrentalsystem.controller;

import com.kiss.carrentalsystem.dto.BookingDTO;
import com.kiss.carrentalsystem.service.Impl.BasePDFGenerator;
import com.kiss.carrentalsystem.service.Impl.ConfirmationPDFDecorator;
import com.kiss.carrentalsystem.service.PDFGenerator;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class PDFExportController {

    private final PDFGenerator pdfGeneratorService;

    public PDFExportController(PDFGenerator pdfGeneratorService) {
        this.pdfGeneratorService = pdfGeneratorService;
    }

    @GetMapping("/pdf/generate")
    public void generatePDF(HttpServletResponse response, BookingDTO bookingDTO) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);

        // Decorating the PDF generator with ConfirmationPDFDecorator
        PDFGenerator decoratedPDFGenerator = new ConfirmationPDFDecorator(pdfGeneratorService);
        decoratedPDFGenerator.generateBookingPDF(response, bookingDTO);
    }
}


