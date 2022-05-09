package com.ZAI.demo.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
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

    @JsonBackReference(value = "paymentCardReference")
    @ManyToOne()
    @JoinColumn(nullable = false)
    private PaymentCard paymentCard;


    @JsonManagedReference(value = "paymentReference")
    @OneToOne()
    private Order order;

}
