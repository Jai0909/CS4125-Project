package com.kiss.carrentalsystem.service;

import com.kiss.carrentalsystem.dto.BookingDTO;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface PDFGenerator {
    void generateBookingPDF(HttpServletResponse response, BookingDTO bookingDTO) throws IOException;
}

