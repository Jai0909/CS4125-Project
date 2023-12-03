package com.kiss.carrentalsystem.service.Impl;

import com.kiss.carrentalsystem.service.PDFGenerator;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.kiss.carrentalsystem.dto.BookingDTO;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Primary
@Service
public class BasePDFGenerator implements PDFGenerator {

    @Override
    public void generateBookingPDF(HttpServletResponse response, BookingDTO bookingDTO) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());

        document.open();
        Font fontTitle = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontTitle.setSize(18);

        Paragraph title = new Paragraph("KISS Car Rental Services", fontTitle);
        title.setAlignment(Paragraph.ALIGN_CENTER);
        title.setSpacingAfter(20); // Add space after title

        Font fontHeading = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        fontHeading.setSize(12);

        PdfPTable table = new PdfPTable(2); // 2 columns
        table.setWidthPercentage(80);
        table.setSpacingBefore(10);
        table.setHorizontalAlignment(Element.ALIGN_CENTER);

        addTableHeader(table, fontHeading, "Parameter", "Details");
        addRow(table, "Car", bookingDTO.getCar().getMakeModel());
        addRow(table, "User", bookingDTO.getUser().getName());
        addRow(table, "Booking ID", bookingDTO.getBookingId());
        addRow(table, "Start Date", bookingDTO.getBookingStartDate().toString());
        addRow(table, "End Date", bookingDTO.getBookingEndDate().toString());

        document.add(title);
        document.add(table);

        // Confirmation statement
        Font fontConfirmation = FontFactory.getFont(FontFactory.HELVETICA_OBLIQUE);
        fontConfirmation.setSize(12);

        Paragraph confirmation = new Paragraph("Booking has been confirmed.", fontConfirmation);
        confirmation.setAlignment(Paragraph.ALIGN_CENTER);
        confirmation.setSpacingBefore(20); // Add space before confirmation

        document.add(confirmation);

        document.close();
    }

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


