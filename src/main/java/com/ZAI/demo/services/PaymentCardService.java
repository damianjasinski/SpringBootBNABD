package com.ZAI.demo.services;


import com.ZAI.demo.exceptions.NotFoundException;
import com.ZAI.demo.models.PaymentCard;
import com.ZAI.demo.repository.PaymentCardRepository;
import com.ZAI.demo.security.MyUserDetails;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PaymentCardService {
    private final PaymentCardRepository paymentCardRepository;

    public PaymentCard addPaymentCard(PaymentCard paymentCard) {
        if (paymentCard.getExpDate().isBefore(LocalDate.now())) {
            throw new NotFoundException("Card is expired");
        }
        return paymentCardRepository.save(paymentCard);
    }

    public PaymentCard deletePaymentCard(Long cardNumber) {
        MyUserDetails user = (MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Long currentUserId = user.getId();
        Optional<PaymentCard> checkCard = paymentCardRepository.findById(cardNumber);
        if (checkCard.isPresent()) {
            if (checkCard.get().getUsers().getId() == currentUserId) {
                paymentCardRepository.deleteById(cardNumber);
                return checkCard.get();
            }
        }
        throw new NotFoundException("Card not found");
    }

    public PaymentCard getPaymentCard(Long cardNumber) {
        return paymentCardRepository.findById(cardNumber).orElseThrow(() -> new NotFoundException("Card number not found"));
    }

}
