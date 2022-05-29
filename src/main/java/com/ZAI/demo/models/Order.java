package com.ZAI.demo.models;


import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "orders")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    LocalDate createdAt;


    @JsonBackReference
    @ManyToOne()
    private Users users;

    @ManyToOne()
    private Seat seat;

    @ManyToOne()
    private Seance seance;


    @OneToOne(mappedBy = "order", cascade=CascadeType.ALL)
    private Payment payment;
}
