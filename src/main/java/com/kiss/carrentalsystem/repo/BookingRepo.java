package com.kiss.carrentalsystem.repo;

import com.kiss.carrentalsystem.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


public interface BookingRepo extends JpaRepository<Booking, Integer> {
    Booking findByBookingId(String booking_id);
}
