package com.ZAI.demo.bootstrap;

import com.ZAI.demo.models.*;
import com.ZAI.demo.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Component
@RequiredArgsConstructor
public class Initializer implements CommandLineRunner {
    private final SeatRepository seatRepository;
    private final UsersRepository usersRepository;
    private final PaymentCardRepository paymentCardRepository;
    private final SeanceRepository seanceRepository;
    private final RoomRepository roomRepository;

    @Override
    public void run(String... args) throws Exception {

        Users user1 = new Users(null, "Jan", "Pankracy", "$2a$12$AvEer2LKlkZfiKlnXBHw../cSiMakfQxl3PyuEMt2gmt9Xa43dEju", LocalDate.now(),
                "pankracy@gmail.com", "USER", null, null);
        usersRepository.save(user1);
        Users user2 = new Users(null, "Jan", "Pankraxcy", "$2a$12$AvEer2LKlkZfiKlnXBHw../cSiMakfQxl3PyuEMt2gmt9Xa43dEju", LocalDate.now(),
                "pankrdacy@gmail.com", "USER", null, null);
        usersRepository.save(user2);
        Users user3 = new Users(null, "Jan", "panek", "$2a$12$AvEer2LKlkZfiKlnXBHw../cSiMakfQxl3PyuEMt2gmt9Xa43dEju", LocalDate.now(),
                "panek@gmail.com", "ADMIN", null, null);
        usersRepository.save(user3);

        PaymentCard paymentCard = new PaymentCard("1234123412341234", LocalDate.now(), "334", user1, null);
        paymentCardRepository.save(paymentCard);


        seatRepository.deleteAll();

        List<Seat> seats = new ArrayList<>(100);
        for (long i = 0; i < 100; i++) {
            if (seatRepository.findById(i).isEmpty()) {
                seats.add(new Seat(i + 1, null));
            }
        }
        seatRepository.saveAll(seats);

        for (long i = 0; i < 3; i ++) {
            roomRepository.save(new Room(i + 1, 100, null));
        }


    }
}
