package com.ZAI.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String dName;

    @OneToMany(mappedBy = "id")
    private Set<Employee> user;

    public Department(String dName) {
        this.dName = dName;
    }
}
