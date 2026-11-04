package com.movieflix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.movieflix.entities.movies;

public interface moviereopsitory extends JpaRepository<movies, Integer> {
}
