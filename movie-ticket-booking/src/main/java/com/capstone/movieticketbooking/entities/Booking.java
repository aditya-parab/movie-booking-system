package com.capstone.movieticketbooking.entities;
import jakarta.persistence.*;
import java.util.*;


@Entity
@Table(name="bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private MovieAuditorium movieAuditorium;

    private Long bookingTime;
    private boolean active; // Soft delete mechanism

    @OneToMany(mappedBy = "booking")
    private List<Seat> bookedSeats;

    // Getters, setters, and other annotations
}

