package com.ZAI.demo.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
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


    @JsonBackReference
    @ManyToOne()
    @JoinColumn(nullable = false)
    public Users users;



    @OneToMany(mappedBy = "paymentCard", fetch = FetchType.EAGER)
    private Set<Payment> paymentSet;



}
