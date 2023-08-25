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

    private Double startTime;
    private Double endTime;

    @OneToMany(mappedBy = "movieAuditorium",fetch = FetchType.EAGER)
    private List<Booking> bookings;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    public Double getStartTime() {
        return startTime;
    }

    public void setStartTime(Double startTime) {
        this.startTime = startTime;
    }

    public Double getEndTime() {
        return endTime;
    }

    public void setEndTime(Double endTime) {
        this.endTime = endTime;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    @Override
    public String toString() {
        return "MovieAuditorium{" +
                "id=" + id +
                ", movie=" + movie +
                ", auditorium=" + auditorium +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}

