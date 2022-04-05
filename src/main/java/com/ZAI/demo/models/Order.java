package com.ZAI.demo.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    LocalDate createdAt;

    @ManyToOne()
    private Users users;

    @ManyToMany(mappedBy = "orderSet")
    private Set<Seat> seatSet;

    @ManyToOne()
    private Seance seance;

    @OneToOne(mappedBy = "order", cascade=CascadeType.ALL)
    private Payment payment;
}
