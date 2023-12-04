package com.kiss.carrentalsystem.service.impl;

import com.kiss.carrentalsystem.dto.BookingDTO;
import com.kiss.carrentalsystem.service.PDFGenerator;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public abstract class PDFDecorator implements PDFGenerator {
    protected PDFGenerator pdfGenerator;

    public PDFDecorator(PDFGenerator pdfGenerator) {
        this.pdfGenerator = pdfGenerator;
    }

    @Override
    public void generateBookingPDF(HttpServletResponse response, BookingDTO bookingDTO) throws IOException {
        pdfGenerator.generateBookingPDF(response, bookingDTO);
    }
}

