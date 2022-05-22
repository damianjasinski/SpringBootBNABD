package com.ZAI.demo.repository;


import com.ZAI.demo.models.PaymentCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PaymentCardRepository extends JpaRepository<PaymentCard, Long> {
    Optional<PaymentCard> getByCardNumber(String cardNumber);
    List<PaymentCard> findAllByUsersId(long id);
}

