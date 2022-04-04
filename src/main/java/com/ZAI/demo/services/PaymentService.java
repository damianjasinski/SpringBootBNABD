package com.ZAI.demo.services;

import com.ZAI.demo.models.Payment;
import com.ZAI.demo.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public boolean addPayment(Payment payment) {
        paymentRepository.save(payment);
        return true;
    }

    //TODO check if user id is equals to loged user id (user a cant show user b payments)
//    public List<Payment> getPayments(long userId) {
//
//    }
}
