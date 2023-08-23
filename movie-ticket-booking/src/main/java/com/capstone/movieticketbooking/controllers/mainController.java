package com.capstone.movieticketbooking.controllers;

import com.capstone.movieticketbooking.entities.Auditorium;
import com.capstone.movieticketbooking.entities.Movie;
import com.capstone.movieticketbooking.entities.Theatre;
import com.capstone.movieticketbooking.services.MovieService;
import com.capstone.movieticketbooking.services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class mainController {


public mainController(){
    System.out.println("main controller is being called.");
}

    @Autowired
    private MovieService movieService;

@Autowired
private TheatreService theatreService;

///////////////GET/////////////////////////
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String initialWelcome(){
        System.out.println("inside welcome.call");

        return "welcome";

    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        System.out.println("inside welcome.call");

        return "login";

    }

    @RequestMapping(value = "/addMovie", method = RequestMethod.GET)
    public String inputMovie(){
        System.out.println("inside addMovie");

        return "addMovie";

    }

    @RequestMapping(value = "/addTheatre", method = RequestMethod.GET)
    public String inputTheatre(){
        System.out.println("inside AddTheatre");

        return "addTheatre";

    }

    @RequestMapping(value = "/setMovie", method = RequestMethod.GET)
    public String setMovie(){
        System.out.println("inside setMovie");

        return "setMovie";

    }




    /////////////POST/////////////////////////

    @PostMapping("/addMovie")
    public String processMovieDetails(@ModelAttribute Movie movie){
        System.out.println("inside addMovie");
        System.out.println(movie);
        movieService.saveMovie(movie);

        return "redirect:/addMovie";

    }

    @PostMapping("/addTheatre")
    public String processTheatreDetails(@RequestParam("name") String name,
                                        @RequestParam("noOfAuditoriums") int noOfAuditoriums,
                                        Model model
                                        ){
        System.out.println("inside AddTheatre POST");
        theatreService.processTheatre(name,noOfAuditoriums);



        return "redirect:/addTheatre";

    }
}
