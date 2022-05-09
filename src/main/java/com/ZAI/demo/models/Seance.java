package com.ZAI.demo.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Basic
    @NotNull
    LocalDate seanceDate;

    @NotNull
    int advertisementTime;

    @OneToMany(mappedBy = "seance")
    private Set<Order> seanceSet;

    @ManyToOne()
    private Room room;

    @ManyToOne()
    private Titles titles;

}
