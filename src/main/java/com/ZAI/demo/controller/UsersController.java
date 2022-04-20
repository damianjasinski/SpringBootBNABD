package com.ZAI.demo.controller;

import com.ZAI.demo.models.Order;
import com.ZAI.demo.models.Payment;
import com.ZAI.demo.models.Users;
import com.ZAI.demo.repository.UsersRepository;
import com.ZAI.demo.security.MyUserDetails;
import com.ZAI.demo.services.OrderService;
import com.ZAI.demo.services.PaymentService;
import com.ZAI.demo.services.UsersService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/user")
public class UsersController implements SecuredController {
    private final UsersService usersService;
    private final PaymentService paymentService;
    private final OrderService orderService;


    @GetMapping("/get/all")
    public List<Users> getUsers() {
        return usersService.getAll();
    }

    @GetMapping("/get/{id}")
    public Users getUser(@PathVariable long id)
    {
        return usersService.getById(id);
    }

    @GetMapping("/get/me")
    public Users getCurrentUser() {
        return usersService.getById(((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }

    @GetMapping("/get/payments")
    public List<Payment> getUserPayments() {
        return paymentService.getPayments(((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }

    @GetMapping("/get/orders")
    public Set<Order> getUserOrders() {
        return orderService.getOrders(((MyUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId());
    }
}
