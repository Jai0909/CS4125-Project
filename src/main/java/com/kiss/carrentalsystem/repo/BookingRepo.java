package com.kiss.carrentalsystem.repo;

import com.kiss.carrentalsystem.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer> {
    Booking findByid(String booking_id);
}
