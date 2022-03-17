package com.ZAI.demo.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    LocalDate createdAt;

    @ManyToOne()
    private Users user;

    @ManyToOne()
    private SeatReserved seatReserved;
}
