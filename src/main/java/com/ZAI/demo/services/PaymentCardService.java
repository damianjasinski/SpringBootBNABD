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
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PaymentCardService {
    private final PaymentCardRepository paymentCardRepository;

    public PaymentCard addPaymentCard(PaymentCard paymentCard) {
        if ( ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId() == paymentCard.getUsers().getId()) {
            if (paymentCard.getExpDate().isBefore(LocalDate.now())) {
                throw new NotFoundException("Card is expired");
            }
            return paymentCardRepository.save(paymentCard);
        }
        throw new NotFoundException("You can't add card for another user!");
    }

    public PaymentCard deletePaymentCard(Long cardNumber) {
        Optional<PaymentCard> checkCard = paymentCardRepository.findById(cardNumber);
        if (checkCard.isPresent()) {
            if (checkCard.get().getUsers().getId() == ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId() ) {
                paymentCardRepository.deleteById(cardNumber);
                return checkCard.get();
            }
        }
        throw new NotFoundException("Card not found");
    }

    public PaymentCard getPaymentCard(String cardNumber) {
        return paymentCardRepository.getByCardNumber(cardNumber).orElseThrow(() -> new NotFoundException("Card number not found"));
    }

    public List<PaymentCard> getMyPaymentCards(long id) {
        List<PaymentCard> cards = paymentCardRepository.findAllByUsersId(id);
        if (cards.size() == 0 ) {
            throw new NotFoundException("No cards available");
        }
        return cards;
    }

}
