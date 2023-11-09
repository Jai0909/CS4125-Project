package com.kiss.carrentalsystem.service;
import com.kiss.carrentalsystem.dto.BookingDTO;
import com.kiss.carrentalsystem.response.UserResponse;

public interface BookingService {
    UserResponse addBooking(BookingDTO bookingDTO);
    UserResponse cancelBooking(BookingDTO bookingDTO);
}
