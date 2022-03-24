package com.ZAI.demo.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    String username;
    String password;

    @CreationTimestamp
    LocalDate createdAt;
    @Column(unique = true)
    @Email
    String email;
    String role;

    @OneToMany(mappedBy = "users")
    private Set<Payment> paymentSet;

    @OneToMany(mappedBy = "users")
    private Set<Order> orderSet;

    @OneToMany(mappedBy = "users")
    private Set<PaymentCard> paymentCardSet;




}
