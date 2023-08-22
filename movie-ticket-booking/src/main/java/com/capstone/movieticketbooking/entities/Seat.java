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
    private Auditorium auditorium; // Relationship with Auditorium

    private Long seatIdentifier;

    @ManyToOne
    private Booking booking;

    // Getters, setters, and other annotations
}


