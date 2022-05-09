package com.ZAI.demo.services;


import com.ZAI.demo.exceptions.NotFoundException;
import com.ZAI.demo.models.Order;
import com.ZAI.demo.models.Payment;
import com.ZAI.demo.models.Seat;
import com.ZAI.demo.repository.OrderRepository;
import com.ZAI.demo.repository.UsersRepository;
import com.ZAI.demo.security.MyUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final PaymentService paymentService;
    private final SeatService seatService;
    private final UsersRepository usersRepository;

    public Order addNewOrder(Order order) {
        if (order.getUsers().getId() == ((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId()) {
            Payment payment = order.getPayment();
            if (payment.isFinalized()) {
                //reserve each seat
                seatService.reserveSeat(order.getSeat(), order);
                order.setCreatedAt(LocalDate.now());
                Order saved = orderRepository.save(order);
                payment.setOrder(saved);
                paymentService.addPayment(payment);
                return saved;
            } else throw new NotFoundException("You must finalize payment");
        }
        throw new NotFoundException("You can't order for other user!");
    }

    public Set<Order> getOrders(long userId) {
        return usersRepository.getById(userId).getOrderSet();
    }


}
