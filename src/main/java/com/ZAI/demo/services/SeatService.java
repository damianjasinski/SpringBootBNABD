package com.ZAI.demo.services;


import com.ZAI.demo.exceptions.NotFoundException;
import com.ZAI.demo.models.Order;
import com.ZAI.demo.models.Seat;
import com.ZAI.demo.models.SeatStatusResponse;
import com.ZAI.demo.repository.OrderRepository;
import com.ZAI.demo.repository.SeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class SeatService {
    private final SeatRepository seatRepository;
    private final OrderRepository orderRepository;


    public void reserveSeat(Seat seat, Order order) {
        Seat orderSeat = seatRepository.getById(order.getSeat().getId());
        Set<Order> orderSet = orderSeat.getOrderSet();
        long seanceId = order.getSeance().getId();
        if (orderSet == null) {
            orderSet = new HashSet<>();
        }
        Optional<Order> isReserved = orderSet.stream()
                .filter((x) -> x.getSeance().getId() == seanceId)
                .findAny();
        if (isReserved.isEmpty()) {
            orderSet.add(order);
            seat.setOrderSet(orderSet);
            seatRepository.save(seat);
        } else {
            throw new NotFoundException("Seat is already reserverd on this seance");
        }
    }

    public List<SeatStatusResponse> getAvailableSeats(long seanceId) {

        List<Seat> seats = seatRepository.findAll();
        List<SeatStatusResponse> availableSeats = new ArrayList<>();
        for (Seat seat : seats) {
            Optional<Order> isReserved = seat.getOrderSet().stream().filter((x) -> x.getSeance().getId() == seanceId)
                    .findAny();
            if (isReserved.isEmpty()) {
                availableSeats.add(new SeatStatusResponse(seat.getId(), true));
            }
            else availableSeats.add(new SeatStatusResponse(seat.getId(), false));
        }
        return availableSeats;
    }
}
