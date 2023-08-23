package com.capstone.movieticketbooking.repository;

import com.capstone.movieticketbooking.entities.Movie;
import com.capstone.movieticketbooking.entities.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat,Long> {

}
