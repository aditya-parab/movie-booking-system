package com.capstone.movieticketbooking.entities;
import jakarta.persistence.*;
import java.util.*;


@Entity
@Table(name="movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String genre;
    private int duration;

    @OneToMany(mappedBy = "movie")
    private List<MovieAuditorium> movieAuditoriums;

    // Getters, setters, and other annotations
}
