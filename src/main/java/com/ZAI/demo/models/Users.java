package com.ZAI.demo.models;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(exclude = "paymentCardSet")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Username cannot be empty!")
    String username;

    @NotBlank(message = "Password cannot be empty!")
    String password;

    @CreationTimestamp
    LocalDate createdAt;

    @Column(unique = true)
    @NotBlank(message = "Email cannot be empty!")
    @Email
    String email;

    String role = "USER";


    @OneToMany(mappedBy = "users")
    private Set<Payment> paymentSet;

    @OneToMany(mappedBy = "users")
    private Set<Order> orderSet;

    @JsonManagedReference
    @OneToMany(mappedBy = "users")
    public Set<PaymentCard> paymentCardSet;




}
