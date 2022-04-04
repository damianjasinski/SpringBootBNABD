package com.ZAI.demo.services;


import com.ZAI.demo.models.Order;
import com.ZAI.demo.models.Payment;
import com.ZAI.demo.repository.OrderRepository;
import com.ZAI.demo.repository.PaymentRepository;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class OrderService {

    private final OrderRepository orderRepository;



    //TODO check if user id is equals to logged user id (user a cant order for user b)
    //check if payment is finalized
    public void generateOrder(Order order, Payment payment) {
        if (payment.isFinalized()) {
            orderRepository.save(order);
        }
    }



}
