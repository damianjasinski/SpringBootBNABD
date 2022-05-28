package com.ZAI.demo.controller;

import com.ZAI.demo.models.PaymentCard;
import com.ZAI.demo.security.MyUserDetails;
import com.ZAI.demo.services.PaymentCardService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/payment_card")
public class PaymentCardController implements SecuredController {

    private final PaymentCardService paymentCardService;

    @PostMapping("/add")
    public ResponseEntity<Map<String, PaymentCard>> addPaymentCard(@Valid @RequestBody PaymentCard paymentCard) {
        PaymentCard paymentCard1 = paymentCardService.addPaymentCard(paymentCard);
        return new ResponseEntity<>(Map.of("success", paymentCard1), HttpStatus.OK);
    }

    @GetMapping("/get/my_cards")
    public ResponseEntity<Map<String, List<PaymentCard>>> geyMyPaymentCards() {
        return new ResponseEntity<>(Map.of("cards", paymentCardService.getMyPaymentCards(((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId())), HttpStatus.OK);
    }

    @GetMapping("/get/{cardNumber}")
    public ResponseEntity<PaymentCard> getPaymentCard(@PathVariable String cardNumber) {
        PaymentCard pCard = paymentCardService.getPaymentCard(cardNumber);
        return new ResponseEntity<>(pCard, HttpStatus.OK);
    }

    @CrossOrigin(origins ="http://localhost:3000")
    @DeleteMapping("/delete/{cardNumber}")
    public ResponseEntity<PaymentCard> deletePaymentCard(@PathVariable Long cardNumber) {
        PaymentCard pCard = paymentCardService.deletePaymentCard(cardNumber);
        return new ResponseEntity<>(pCard, HttpStatus.OK);
    }

}
