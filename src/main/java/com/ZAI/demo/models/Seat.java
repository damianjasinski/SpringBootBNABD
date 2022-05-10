package com.ZAI.demo.models;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id")
public class Seat {

    @Id
    private long id;

    @OneToMany(mappedBy = "seat")
    private Set<Order> orderSet;

}
