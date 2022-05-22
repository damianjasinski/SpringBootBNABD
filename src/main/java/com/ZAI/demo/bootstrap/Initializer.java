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
    private final CategoryRepository categoryRepository;
    private final TitlesRepository titlesRepository;

    @Override
    public void run(String... args) throws Exception {

        Users user1 = new Users(null, "Jan", "Pankracy", "$2a$12$AvEer2LKlkZfiKlnXBHw../cSiMakfQxl3PyuEMt2gmt9Xa43dEju", LocalDate.now(),
                "pankracy@gmail.com", "USER", new HashSet<>(), new HashSet<>());
        usersRepository.save(user1);
        Users user2 = new Users(null, "Jan", "Pankraxcy", "$2a$12$AvEer2LKlkZfiKlnXBHw../cSiMakfQxl3PyuEMt2gmt9Xa43dEju", LocalDate.now(),
                "pankrdacy@gmail.com", "USER", new HashSet<>(), new HashSet<>());
        usersRepository.save(user2);
        Users user3 = new Users(null, "Jan", "panek", "$2a$12$AvEer2LKlkZfiKlnXBHw../cSiMakfQxl3PyuEMt2gmt9Xa43dEju", LocalDate.now(),
                "panek@gmail.com", "ADMIN", new HashSet<>(), new HashSet<>());
        usersRepository.save(user3);

        PaymentCard paymentCard = new PaymentCard("1234123412341234", LocalDate.now(), "334", user1, new HashSet<>());
        paymentCardRepository.save(paymentCard);
        PaymentCard paymentCard2 = new PaymentCard("1234123412343433", LocalDate.now(), "123", user1, new HashSet<>());
        paymentCardRepository.save(paymentCard2);

        PaymentCard paymentCard3 = new PaymentCard("1234123412343438", LocalDate.now(), "123", user2, new HashSet<>());
        paymentCardRepository.save(paymentCard3);


        seatRepository.deleteAll();

        List<Seat> seats = new ArrayList<>(100);
        for (long i = 0; i < 100; i++) {
            if (seatRepository.findById(i).isEmpty()) {
                seats.add(new Seat(i + 1, new HashSet<>()));
            }
        }
        seatRepository.saveAll(seats);

        for (long i = 0; i < 3; i ++) {
            roomRepository.save(new Room(i + 1, 100, new HashSet<>()));
        }

        Category category1 = new Category(1L, "Fantasy");
        categoryRepository.save(category1);

        Titles titles1 = new Titles(5L, List.of(5L), "https://image.posterlounge.pl/images/l/1899145.jpg", "Harry Potter and Chamber of Sins", 120, new HashSet<>(), new HashSet<>());
        titlesRepository.save(titles1);

        Seance seance1 = new Seance(1L, LocalDate.now().plusDays(1), 15, null, titles1);
        Seance seance2 = new Seance(1L, LocalDate.now().plusDays(5), 125, null, titles1);
        seanceRepository.saveAll(List.of(seance1, seance2));
    }
}
