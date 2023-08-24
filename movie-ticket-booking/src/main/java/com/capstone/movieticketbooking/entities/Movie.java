package com.capstone.movieticketbooking.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.*;


@Entity
@Table(name="movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String title;

    private String genre;


    @OneToMany(mappedBy = "movie")
    @JsonIgnore
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
                '}';
    }
}
