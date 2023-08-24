package com.capstone.movieticketbooking.services;

import com.capstone.movieticketbooking.entities.Movie;
import com.capstone.movieticketbooking.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public Movie createMovie(String genre,String title){
        Movie movie = new Movie();
        movie.setTitle(title);
        movie.setGenre(genre);
        movieRepository.save(movie);
        return movie;

    }
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}
