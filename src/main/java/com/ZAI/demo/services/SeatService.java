package com.ZAI.demo.services;


import com.ZAI.demo.exceptions.NotFoundException;
import com.ZAI.demo.models.Order;
import com.ZAI.demo.models.Seat;
import com.ZAI.demo.repository.SeatRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SeatService {
    private final OrderService orderService;
    private final SeatRepository seatRepository;


    public void reserveSeat(Seat seat, Order order) {
        Set<Order> orderSet = seat.getOrderSet();
        long seanceId = order.getSeance().getId();
        List<Order> isReserved = orderSet.stream()
                .filter((x) -> x.getSeance().getId() == seanceId)
                .collect(Collectors.toList());
        if (isReserved.isEmpty()) {
            orderSet.add(order);
            seat.setOrderSet(orderSet);
            seatRepository.save(seat);
        } else {
            throw new NotFoundException("Seat is already reserverd on this seance");
        }
    }

    @PostConstruct
    public void init() {
        List<Seat> seats = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            seats.add(new Seat(i, null));
        }
        seatRepository.saveAll(seats);
    }

}
