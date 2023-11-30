package com.kiss.carrentalsystem.repo;

import com.kiss.carrentalsystem.entity.CardDetails;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CardDetailsRepo extends JpaRepository<CardDetails, Integer> {

    List<CardDetails> findByCardHolder(String cardHolder);
    CardDetails findByCardNumber(int cardNumber);
}
