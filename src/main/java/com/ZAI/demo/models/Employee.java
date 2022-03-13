package com.ZAI.demo.models;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long emp_id;

    private String firstName;

    private String lastName;

    private double salary;

    @ManyToOne()
    private Department department;

    public Employee(String firstName, String lastName, double salary, Department department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
        this.department = department;
    }
}
