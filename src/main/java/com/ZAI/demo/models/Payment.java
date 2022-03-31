package com.ZAI.demo.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cardNumber;
    int ammount;
    LocalDate createdAt;
    boolean finalized;

    @ManyToOne()
    private PaymentCard paymentCard;

    @ManyToOne()
    private Users users;

}
