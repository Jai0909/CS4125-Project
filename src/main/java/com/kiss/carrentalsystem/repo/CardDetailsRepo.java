package com.kiss.carrentalsystem.repo;

import com.kiss.carrentalsystem.entity.CardDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CardDetailsRepo extends JpaRepository<CardDetails, Integer> {

    List<CardDetails> findByCardHolder(String cardHolder);
    CardDetails findByCardNumber(int cardNumber);
}
