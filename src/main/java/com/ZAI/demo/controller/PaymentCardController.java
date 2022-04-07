package com.ZAI.demo.controller;

import com.ZAI.demo.models.PaymentCard;
import com.ZAI.demo.services.PaymentCardService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payment_card")
public class PaymentCardController {

    private final PaymentCardService paymentCardService;

    @PostMapping("/add")
    public ResponseEntity<Map<String, PaymentCard>> addPaymentCard(@Valid @RequestBody PaymentCard paymentCard) {
        PaymentCard paymentCard1 = paymentCardService.addPaymentCard(paymentCard);
        return new ResponseEntity<>(Map.of("success", paymentCard1), HttpStatus.OK);
    }

    @GetMapping("/get/{cardNumber}")
    public ResponseEntity<PaymentCard> getPaymentCard(@PathVariable Long cardNumber) {
        PaymentCard pCard = paymentCardService.getPaymentCard(cardNumber);
        return new ResponseEntity<>(pCard, HttpStatus.OK);
    }

}
