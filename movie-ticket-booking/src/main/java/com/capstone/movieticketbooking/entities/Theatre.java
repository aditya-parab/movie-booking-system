package com.capstone.movieticketbooking.entities;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name="theatres")
public class Theatre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "theatre")
    private List<Auditorium> auditoriums;

    // Getters, setters, and other annotations
}
