package com.kiss.carrentalsystem.service;
import com.kiss.carrentalsystem.dto.BookingDTO;
import com.kiss.carrentalsystem.response.DefaultResponse;

public interface BookingService {
    DefaultResponse addBooking(BookingDTO bookingDTO);
    DefaultResponse cancelBooking(BookingDTO bookingDTO);
}
