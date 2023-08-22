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
    private double duration;

    @OneToMany(mappedBy = "movie")
    private List<MovieAuditorium> movieAuditoriums;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public List<MovieAuditorium> getMovieAuditoriums() {
        return movieAuditoriums;
    }

    public void setMovieAuditoriums(List<MovieAuditorium> movieAuditoriums) {
        this.movieAuditoriums = movieAuditoriums;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", duration=" + duration +
                ", movieAuditoriums=" + movieAuditoriums +
                '}';
    }
}
