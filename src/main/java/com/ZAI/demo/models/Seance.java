package com.ZAI.demo.models;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
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

    @NotNull
    @JsonFormat(pattern="dd/MM/yyyy HH:mm")
    private LocalDateTime seanceDate;

    @NotNull
    int advertisementTime;

//    @OneToMany(mappedBy = "seance")
//    private Set<Order> orderSet;

    private Long roomId;

    @ManyToOne()
    private Titles titles;

}
