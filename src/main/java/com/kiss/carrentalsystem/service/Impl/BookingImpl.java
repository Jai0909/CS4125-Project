package com.kiss.carrentalsystem.service.Impl;

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

    @Override
    public DefaultResponse addBooking(BookingDTO bookingDTO) {
        Booking booking = new Booking(
                bookingDTO.getCar(),
                bookingDTO.getUser(),
                bookingDTO.getBookingId(),
                bookingDTO.getBookingEndDate(),
                bookingDTO.getBookingStartDate()
        );
        bookingRepo.save(booking);
        return new DefaultResponse("Booking Created", true);
    }
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
