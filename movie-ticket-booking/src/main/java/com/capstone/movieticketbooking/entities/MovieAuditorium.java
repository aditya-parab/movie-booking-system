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
    private Auditorium auditorium;

    @OneToMany(mappedBy = "movieAuditorium")
    private List<Booking> bookings;

    @OneToMany(mappedBy = "movieAuditorium")
    private List<Seat> seats;

    // Getters, setters, and other annotations
}
