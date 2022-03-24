package com.ZAI.demo.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;

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

    @JsonBackReference
    @ManyToOne()
    public Users users;



    @OneToMany(mappedBy = "paymentCard", fetch = FetchType.EAGER)
    private Set<Payment> paymentSet;



}
