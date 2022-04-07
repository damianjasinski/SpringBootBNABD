package com.ZAI.demo.services;


import com.ZAI.demo.exceptions.NotFoundException;
import com.ZAI.demo.models.PaymentCard;
import com.ZAI.demo.repository.PaymentCardRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PaymentCardService {
    private final PaymentCardRepository paymentCardRepository;

    public PaymentCard addPaymentCard(PaymentCard paymentCard) {
        return paymentCardRepository.save(paymentCard);
    }

    public PaymentCard deletePaymentCard(Long cardNumber) {
        Optional<PaymentCard> checkCard = paymentCardRepository.findById(cardNumber);
        if (checkCard.isEmpty()) throw new NotFoundException("Card number not found");
        paymentCardRepository.deleteById(cardNumber);
        return checkCard.get();
    }

    public PaymentCard getPaymentCard(Long cardNumber) {
        return paymentCardRepository.findById(cardNumber).orElseThrow(() -> new NotFoundException("Card number not found"));
    }

}
