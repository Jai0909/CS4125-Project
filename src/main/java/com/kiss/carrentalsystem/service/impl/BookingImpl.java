package com.kiss.carrentalsystem.service.impl;

import com.kiss.carrentalsystem.dto.BookingDTO;
import com.kiss.carrentalsystem.entity.Booking;
import com.kiss.carrentalsystem.repo.BookingRepo;
import com.kiss.carrentalsystem.response.DefaultResponse;
import com.kiss.carrentalsystem.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingImpl implements BookingService {

    @Autowired
    private BookingRepo bookingRepo;

    // This is the method to add a new booking
    @Override
    public DefaultResponse addBooking(BookingDTO bookingDTO) {
        // This creates a new Booking entity from the BookingDTO
        Booking booking = new Booking(
                bookingDTO.getUser(),
                bookingDTO.getCar(),
                bookingDTO.getBookingId(),
                bookingDTO.getBookingEndDate(),
                bookingDTO.getBookingStartDate()
                );
        // This saves the booking to the database using the BookingRepo
        bookingRepo.save(booking);
        return new DefaultResponse("Booking Created", true);
    }

    // This is the method to cancel an existing booking
    @Override
    public DefaultResponse cancelBooking(BookingDTO bookingDTO) {
        Booking booking = bookingRepo.findByBookingId(bookingDTO.getBookingId());
        if (booking != null) {
            bookingRepo.delete(booking);
            return new DefaultResponse("Booking Deleted", true);
        }
        else{
            return new DefaultResponse("Booking Cannot Be Deleted", false);
        }
    }
}
