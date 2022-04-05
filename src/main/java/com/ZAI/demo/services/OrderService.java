package com.ZAI.demo.services;


import com.ZAI.demo.exceptions.NotFoundException;
import com.ZAI.demo.models.Order;
import com.ZAI.demo.models.Payment;
import com.ZAI.demo.repository.OrderRepository;
import com.ZAI.demo.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@AllArgsConstructor
@Data
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final PaymentService paymentService;


    //TODO check if user id is equals to logged user id (user a cant order for user b)
    //check if payment is finalized
    public void addNewOrder(Order order) {
        Payment payment = order.getPayment();
        if (payment.isFinalized()) {
            order.setCreatedAt(LocalDate.now());
            payment.setOrder(order);
            Order saved = orderRepository.save(order);
            paymentService.addPayment(payment);
        }
        else throw new NotFoundException("You must finalize payment");
    }



}
