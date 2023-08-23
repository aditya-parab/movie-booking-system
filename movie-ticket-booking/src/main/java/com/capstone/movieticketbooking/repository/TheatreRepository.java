package com.capstone.movieticketbooking.repository;

import com.capstone.movieticketbooking.entities.Movie;
import com.capstone.movieticketbooking.entities.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreRepository extends JpaRepository<Theatre,Long> {
    public Theatre findTheatreByName(String name);
}
