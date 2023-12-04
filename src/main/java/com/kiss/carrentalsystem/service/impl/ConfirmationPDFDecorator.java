package com.kiss.carrentalsystem.service.impl;

import com.kiss.carrentalsystem.dto.BookingDTO;
import com.kiss.carrentalsystem.service.PDFGenerator;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ConfirmationPDFDecorator extends PDFDecorator {

    public ConfirmationPDFDecorator(PDFGenerator pdfGenerator) {
        super(pdfGenerator); // The constructor of the parent class (PDFDecorator) is called with the provided PDFGenerator
    }

    @Override
    public void generateBookingPDF(HttpServletResponse response, BookingDTO bookingDTO) throws IOException {
        super.generateBookingPDF(response, bookingDTO);
        addConfirmationStatement(response);
    }

    // This method adds the confirmation statement to the receipt
    private void addConfirmationStatement(HttpServletResponse response) throws IOException {
        Document document = new Document();
        PdfWriter.getInstance(document, response.getOutputStream());
        document.open();

        Font fontConfirmation = FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE);
        fontConfirmation.setSize(12);

        Paragraph confirmation = new Paragraph("Booking has been confirmed.", fontConfirmation);
        confirmation.setAlignment(Paragraph.ALIGN_CENTER);
        confirmation.setSpacingBefore(20);

        document.add(confirmation);
        document.close();
    }
}

