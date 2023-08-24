package com.capstone.movieticketbooking.services;

import com.capstone.movieticketbooking.entities.Auditorium;
import com.capstone.movieticketbooking.entities.Movie;
import com.capstone.movieticketbooking.entities.MovieAuditorium;
import com.capstone.movieticketbooking.repository.MovieAuditoriumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieAuditoriumService {

    @Autowired
    MovieAuditoriumRepository movieAuditoriumRepository;

    public MovieAuditorium processMovieAuditorium(Movie movie, Auditorium auditorium, double startTime, double endTime){
        MovieAuditorium movieAuditorium = new MovieAuditorium();
        movieAuditorium.setAuditorium(auditorium);
        movieAuditorium.setMovie(movie);
        movieAuditorium.setStartTime(startTime);
        movieAuditorium.setEndTime(endTime);
        movieAuditoriumRepository.save(movieAuditorium);
        System.out.println("movie audi saved success!");
        return movieAuditorium;
    }
}
