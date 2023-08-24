package com.capstone.movieticketbooking.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToMany(mappedBy = "auditorium", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<MovieAuditorium> movieAuditoriums;

    @OneToMany(mappedBy = "auditorium",fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Seat> seats; // Relationship with Seat

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public void setTheatre(Theatre theatre) {
        this.theatre = theatre;
    }

    public List<MovieAuditorium> getMovieAuditoriums() {
        return movieAuditoriums;
    }

    public void setMovieAuditoriums(List<MovieAuditorium> movieAuditoriums) {
        this.movieAuditoriums = movieAuditoriums;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    @Override
    public String toString() {
        return "Auditorium{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", theatre=" + theatre +
                '}';
    }
}


