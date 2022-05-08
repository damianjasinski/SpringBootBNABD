package com.ZAI.demo.controller;

import com.ZAI.demo.models.Order;
import com.ZAI.demo.models.Payment;
import com.ZAI.demo.services.OrderService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/order")
public class OrderController implements SecuredController {
    private final OrderService orderService;

    @PostMapping("/add")
    public ResponseEntity<Map<String, Order>> addOrder(@Valid @RequestBody Order order) {
        Order order1 = orderService.addNewOrder(order);
        return new ResponseEntity<>(Map.of("success", order1), HttpStatus.OK);
    }

}
