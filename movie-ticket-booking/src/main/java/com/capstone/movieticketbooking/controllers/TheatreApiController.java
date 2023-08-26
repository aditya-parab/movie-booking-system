package com.capstone.movieticketbooking.controllers;



import com.capstone.movieticketbooking.entities.Auditorium;
import com.capstone.movieticketbooking.entities.Movie;
import com.capstone.movieticketbooking.entities.Theatre;

import com.capstone.movieticketbooking.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/theatres")
public class TheatreApiController {
    @Autowired
    private TheatreRepository theatreRepository;


    //get all theatres
    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Theatre> getAllTheatres() {
        List<Theatre> theatres = theatreRepository.findAll();
        return theatres;
    }

    //get all auditoriums associated with a theatre
    @GetMapping("/{theatreName}/auditoriums")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Auditorium> getAuditoriumsFromTheatre(@PathVariable String theatreName) {
        Theatre theatre =  theatreRepository.findTheatreByName(theatreName);



            List<Auditorium> auditoriums = theatre.getAuditoriums();
            return auditoriums;

    }

}
