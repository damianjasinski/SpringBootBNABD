package com.ZAI.demo.services;

import com.ZAI.demo.exceptions.NotFoundException;
import com.ZAI.demo.models.Order;
import com.ZAI.demo.models.Payment;
import com.ZAI.demo.repository.PaymentRepository;
import com.ZAI.demo.repository.UsersRepository;
import com.ZAI.demo.security.MyUserDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
@AllArgsConstructor
public class PaymentService {
    private final PaymentRepository paymentRepository;
    private final UsersRepository usersRepository;

    public boolean addPayment(Payment payment) {
        payment.setCreatedAt(LocalDate.now());
        if (payment.getPaymentCard().getExpDate().isBefore(LocalDate.now())) {
            throw new NotFoundException("Card is expired");
        }
        paymentRepository.save(payment);
        return true;
    }

    public List<Payment> getPayments(long userId) {
        return usersRepository.getById(userId).getOrderSet()
                .stream()
                .map(Order::getPayment)
                .collect(Collectors.toList());
    }
}
