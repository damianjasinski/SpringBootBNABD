package com.ZAI.demo.services;


import com.ZAI.demo.exceptions.NotFoundException;
import com.ZAI.demo.models.Order;
import com.ZAI.demo.models.Seance;
import com.ZAI.demo.models.Seat;
import com.ZAI.demo.repository.OrderRepository;
import com.ZAI.demo.repository.SeatRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SeatService {
    private final SeatRepository seatRepository;
    private final OrderRepository orderRepository;


    public void reserveSeat(Seat seat, Order order) {
        Set<Order> orderSet = seat.getOrderSet();
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

    public List <Seat> returnReservedSeats(Seance seance){
        long seanceId = seance.getId();

        List<Seat> seats = seatRepository.findAll();
        List<Seat> reservedSeats = new ArrayList<>();

        for (Seat seat : seats){
            Optional<Order> isReserved = seat.getOrderSet().stream().filter((x) -> x.getSeance().getId() == seanceId)
                    .findAny();
            if(isReserved.isPresent()){
                reservedSeats.add(seat);
            }
        }
        return reservedSeats;
    }

    @PostConstruct
    public void init() {
        seatRepository.save(new Seat(1, new HashSet<>()));
//        List<Seat> seats = new ArrayList<>(100);
//        for (int i = 0; i < 100; i++) {
//            seats.add(new Seat(i, new HashSet<>()));
//        }
//        seatRepository.saveAll(seats);
    }

}
