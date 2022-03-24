package com.ZAI.demo.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentCard {

    @Id
    private long card_number;
    LocalDate expDate;
    int cvv;

    @ManyToOne()
    private Users users;

    @OneToMany(mappedBy = "paymentCard")
    private Set<Payment> paymentSet;

}
