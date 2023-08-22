package com.capstone.movieticketbooking.entities;
import jakarta.persistence.*;
import java.util.*;


@Entity
@Table(name="movieauditoriums")
public class MovieAuditorium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Movie movie;

    @ManyToOne
    private Auditorium auditorium; // Relationship with Auditorium

    private Long startTime;
    private Long endTime;

    @OneToMany(mappedBy = "movieAuditorium")
    private List<Booking> bookings;

    // Other fields, getters, setters, and other annotations
}

