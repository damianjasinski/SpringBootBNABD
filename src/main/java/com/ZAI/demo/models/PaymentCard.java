package com.ZAI.demo.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonFormat(pattern="yy/MM/dd")
    LocalDate expDate;

    @NotNull
    @Pattern(regexp = "[0-9]{3}")
    String cvv;

    @ManyToOne()
    @JoinColumn(nullable = false)
    public Users users;

    @OneToMany(mappedBy = "paymentCard", fetch = FetchType.EAGER)
    private Set<Payment> paymentSet;



}
