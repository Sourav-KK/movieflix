package com.movieflix.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Table(name="movies")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false) // default length = 255
    @NotBlank(message = "Movie title required.")
    private String title;

    @ElementCollection // for foreign key
    @CollectionTable
    private Set<String> director;

    @ElementCollection
    @CollectionTable
    private Set<String> genre;

    @ElementCollection
    @CollectionTable
    private Set<String> cast;

    private Integer year;

    private String poster;

    @Column(nullable = false) // default length = 255
    @NotBlank(message = "Movie rating required.")
    private Float rating;

}
