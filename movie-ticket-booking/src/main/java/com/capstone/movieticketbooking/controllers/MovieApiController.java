package com.capstone.movieticketbooking.controllers;

import com.capstone.movieticketbooking.entities.Auditorium;
import com.capstone.movieticketbooking.entities.Movie;
import com.capstone.movieticketbooking.entities.MovieAuditorium;
import com.capstone.movieticketbooking.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/movies")
public class MovieApiController {
    @Autowired
    private MovieRepository movieRepository;


    //get all movies
    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Movie> getAllMovies() {
        List<Movie> movies = movieRepository.findAll();
        return movies;
    }

    //for a movie, get all theatres and all timings
    @GetMapping("/{movieTitle}/theatres")
    public ResponseEntity<Map<String, List<String>>> getTheatresForMovie(@PathVariable String movieTitle) {
        Movie movie = movieRepository.findMovieByTitle(movieTitle);
        if (movie != null) {
            Map<String, List<String>> theatreTimingsMap = new HashMap<>();

            for (MovieAuditorium movieAuditorium : movie.getMovieAuditoriums()) {
                Auditorium auditorium = movieAuditorium.getAuditorium();
                String theatreName = auditorium.getTheatre().getName();
                String timing = movieAuditorium.getStartTime() + " - " + movieAuditorium.getEndTime();

                if (!theatreTimingsMap.containsKey(theatreName)) {
                    theatreTimingsMap.put(theatreName, new ArrayList<>());
                }
                theatreTimingsMap.get(theatreName).add(timing);
            }

            return ResponseEntity.ok(theatreTimingsMap);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
