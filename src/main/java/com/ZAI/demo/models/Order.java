package com.ZAI.demo.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    LocalDate createdAt;

    @JsonBackReference(value = "userOrderSet")
    @ManyToOne()
    private Users users;

    @ManyToOne()
    @JsonBackReference(value = "seatReference")
    private Seat seat;

    @ManyToOne()
    private Seance seance;

    @JsonBackReference(value = "paymentReference")
    @OneToOne(mappedBy = "order", cascade=CascadeType.ALL)
    private Payment payment;
}
