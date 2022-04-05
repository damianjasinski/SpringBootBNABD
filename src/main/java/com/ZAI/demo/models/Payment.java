package com.ZAI.demo.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    int ammount;

    @Basic
    LocalDate createdAt;

    @NotNull
    boolean finalized;

    @ManyToOne()
    private PaymentCard paymentCard;

//    @ManyToOne()
//    @JoinColumn(nullable = false)
//    private Users users;

    @OneToOne()
    private Order order;

}
