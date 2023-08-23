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

    @ManyToOne
    private Booking booking;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Auditorium getAuditorium() {
        return auditorium;
    }

    public void setAuditorium(Auditorium auditorium) {
        this.auditorium = auditorium;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "id=" + id +
                ", auditorium=" + auditorium +
                ", booking=" + booking +
                '}';
    }
}


