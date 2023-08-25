package com.capstone.movieticketbooking.repository;

import com.capstone.movieticketbooking.entities.Auditorium;
import com.capstone.movieticketbooking.entities.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Long> {

}
