package com.kiss.carrentalsystem.service.Impl;

import com.kiss.carrentalsystem.dto.BookingDTO;
import com.kiss.carrentalsystem.entity.Booking;
import com.kiss.carrentalsystem.repo.BookingRepo;
import com.kiss.carrentalsystem.response.UserResponse;
import com.kiss.carrentalsystem.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;

public class BookingImpl implements BookingService {
    @Autowired
    private BookingRepo bookingRepo;

    @Override
    public UserResponse addBooking(BookingDTO bookingDTO) {
        Booking booking = new Booking(
                bookingDTO.getBooking_id(),
                bookingDTO.getCar(),
                bookingDTO.getUser(),
                bookingDTO.getBookingEndDate(),
                bookingDTO.getBookingStartDate()
        );
        bookingRepo.save(booking);
        return new UserResponse("Booking Created", true);
    }
    @Override
    public UserResponse cancelBooking(BookingDTO bookingDTO) {
        Booking booking = bookingRepo.findByid(bookingDTO.getBooking_id());
        if (booking != null) {
            bookingRepo.delete(booking);
            return new UserResponse("Booking Deleted", true);
        }
        else{
            return new UserResponse("Booking Cannot Be Deleted", false);
        }
    }
}
