package com.ZAI.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seance {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    LocalDate seance_date;
    int advertisement_time;

    @OneToMany(mappedBy = "seance")
    private Set<Order> seanceSet;

    @ManyToOne()
    private Room room;

    @ManyToOne()
    private Titles titles;

}
