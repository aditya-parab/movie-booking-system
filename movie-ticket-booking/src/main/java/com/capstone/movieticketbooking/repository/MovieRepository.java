package com.capstone.movieticketbooking.repository;

import com.capstone.movieticketbooking.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie,Long> {

}
