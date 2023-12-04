package com.kiss.carrentalsystem.service.Impl;

import com.kiss.carrentalsystem.businesslogic.BusinessLogic;
import com.kiss.carrentalsystem.dto.BookingDTO;
import com.kiss.carrentalsystem.service.PDFGenerator;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Primary
@Service
public class BasePDFGenerator implements PDFGenerator {

    private final BusinessLogic businessLogic; // This is a reference to the BusinessLogic component

    // The constructor so that the Business Logic Dependency can be injected
    public BasePDFGenerator(BusinessLogic businessLogic) {
        this.businessLogic = businessLogic;
    }

    // This is the method that generates the PDF receipt containing the booking details
    @Override
    public void generateBookingPDF(HttpServletResponse response, BookingDTO bookingDTO) throws IOException {
        // This calculates the final price of the booking by applying the necessary discounts
        double finalizedPrice = businessLogic.calculateDiscount(bookingDTO, bookingDTO.getCar());

        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        // Creation and Formatting of the PDF Document
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);

        Paragraph title = new Paragraph("KISS Car Rental Services", fontTitle);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        title.setSpacingAfter(20);

        Font fontHeading = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontHeading.setSize(12);

        PdfPTable table = new PdfPTable(2);
        table.setWidthPercentage(80);
        table.setSpacingBefore(10);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);

        addTableHeader(table, fontHeading, "Parameter", "Details");
        addRow(table, "Car", bookingDTO.getCar());
        addRow(table, "User", bookingDTO.getUser());
        addRow(table, "Booking ID", bookingDTO.getBookingId());
        addRow(table, "Start Date", bookingDTO.getBookingStartDate().toString());
        addRow(table, "End Date", bookingDTO.getBookingEndDate().toString());
        addRow(table, "Finalized Price", String.valueOf(finalizedPrice));

        document.add(title);
        document.add(table);

        Font fontConfirmation = FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE);
        fontConfirmation.setSize(12);

        Paragraph confirmation = new Paragraph("Booking has been confirmed.", fontConfirmation);
        confirmation.setAlignment(Paragraph.ALIGN_CENTER);
        confirmation.setSpacingBefore(20);

        document.add(confirmation);

        document.close();
    }

    // Helper methods for table headers and rows
    private void addTableHeader(PdfPTable table, Font font, String... headers) {
        for (String header : headers) {
            PdfPCell cell = new PdfPCell(new Phrase(header, font));
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
        }
    }

    private void addRow(PdfPTable table, String param, String detail) {
        table.addCell(param);
        table.addCell(detail);
    }
}


