package com.ZAI.demo.models;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Titles {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    String name;
    int length;

    @OneToMany(mappedBy = "titles")
    private Set<Seance> seanceSet;

    @ManyToMany
    private Set<Category> categorySet;

}
