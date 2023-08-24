package com.capstone.movieticketbooking.repository;

import com.capstone.movieticketbooking.entities.Auditorium;
import com.capstone.movieticketbooking.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditoriumRepository extends JpaRepository<Auditorium,Long> {
    public Auditorium findAuditoriumByName(String name);
}
