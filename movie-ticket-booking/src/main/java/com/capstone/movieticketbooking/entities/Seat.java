package com.capstone.movieticketbooking.entities;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name="seats")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private MovieAuditorium movieAuditorium;

    private Long seatIdentifier;

    @ManyToOne
    private Booking booking; // One-to-many relationship with Booking

    // Getters, setters, and other annotations
}

