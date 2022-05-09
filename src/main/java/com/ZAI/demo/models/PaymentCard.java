package com.ZAI.demo.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentCard {
    
    @Id
    @NotNull
    @Pattern(regexp = "[0-9]{16}")
    private String cardNumber;

    @Basic
    @NotNull
    LocalDate expDate;

    @NotNull
    @Pattern(regexp = "[0-9]{3}")
    String cvv;


    @JsonBackReference(value = "paymentCardSetUserReference")
    @ManyToOne()
    @JoinColumn(nullable = false)
    public Users users;



    @JsonManagedReference(value = "paymentCardReference")
    @OneToMany(mappedBy = "paymentCard", fetch = FetchType.EAGER)
    private Set<Payment> paymentSet;



}
