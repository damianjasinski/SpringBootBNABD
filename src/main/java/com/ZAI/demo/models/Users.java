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
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.Set;
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(exclude = "paymentCardSet")
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Firstname cannot be empty!")
    String userFirstName;

    @NotBlank(message = "Surname cannot be empty!")
    String userSurname;

    @Pattern(regexp = "^.{8,}$")
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
    private Set<Order> orderSet;

    @OneToMany(mappedBy = "users")
    public Set<PaymentCard> paymentCardSet;




}
