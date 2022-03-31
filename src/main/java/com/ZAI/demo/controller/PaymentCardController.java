package com.ZAI.demo.controller;

import com.ZAI.demo.models.PaymentCard;
import com.ZAI.demo.services.PaymentCardService;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Data
@RequestMapping("/api/payment_card")
public class PaymentCardController {

    private final PaymentCardService paymentCardService;

    @PostMapping("/add")
    public ResponseEntity<String> addPaymentCard(@Valid @RequestBody PaymentCard paymentCard) {
        paymentCardService.addPaymentCard(paymentCard);
        return new ResponseEntity<>("Payment card added succesfully", HttpStatus.OK);
    }

    @GetMapping("/get/{cardNumber}")
    public ResponseEntity<PaymentCard> getPaymentCard(@PathVariable Long cardNumber) {
        PaymentCard pCard = paymentCardService.getPaymentCard(cardNumber);
        return new ResponseEntity<>(pCard, HttpStatus.OK);
    }

}
