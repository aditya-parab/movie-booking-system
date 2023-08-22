package com.capstone.movieticketbooking.entities;
import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name="auditoriums")
public class Auditorium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    private Theatre theatre;

    @OneToMany(mappedBy = "auditorium")
    private List<MovieAuditorium> movieAuditoriums;

    // Getters, setters, and other annotations
}

