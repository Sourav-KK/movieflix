package com.movieflix.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    private Integer id;

    @NotBlank(message = "Please provide movie title")
    private String title;

    private Set<String> director;

    private Set<String> genre;

    @NotBlank(message = "Please provide movie cast.")
    private Set<String> cast;

    private Integer year;

    @NotBlank(message = "Please provide movie poster")
    private String poster;

    private Float rating;

    @NotBlank(message = "Please provide poster url")
    private String posterUrl; // url of image
}
