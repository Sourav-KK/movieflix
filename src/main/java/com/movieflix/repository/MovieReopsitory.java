package com.movieflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.movieflix.entities.Movies;

public interface MovieReopsitory extends JpaRepository<Movies, Integer> {
}
