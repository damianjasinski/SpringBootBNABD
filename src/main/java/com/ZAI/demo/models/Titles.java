package com.ZAI.demo.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Titles {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Transient
    private List<Long> categoriesId;

    String imUrl;

    @NotBlank
    String name;

    @NotNull
    int length;

    @OneToMany(mappedBy = "titles")
    private Set<Seance> seanceSet;

    @ManyToMany()
    @JoinTable(
            name = "titles_category",
            joinColumns = @JoinColumn(name = "titles_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categorySet;

}
