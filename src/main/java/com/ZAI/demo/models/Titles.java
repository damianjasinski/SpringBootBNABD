package com.ZAI.demo.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Titles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Transient
    private List<Long> categoriesId;

    String imUrl = "https://image.posterlounge.pl/images/l/1899145.jpg";

    @NotBlank
    String name;

    @NotNull
    int length;

    @JsonIgnore
    @OneToMany(mappedBy = "titles")
    private Set<Seance> seanceSet;

    @ManyToMany()
    @JoinTable(
            name = "titles_category",
            joinColumns = @JoinColumn(name = "titles_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categorySet;

}
