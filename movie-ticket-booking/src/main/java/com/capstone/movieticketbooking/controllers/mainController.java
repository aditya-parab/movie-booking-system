package com.capstone.movieticketbooking.controllers;

import com.capstone.movieticketbooking.entities.Auditorium;
import com.capstone.movieticketbooking.entities.Movie;
import com.capstone.movieticketbooking.entities.MovieAuditorium;
import com.capstone.movieticketbooking.entities.Theatre;
import com.capstone.movieticketbooking.repository.AuditoriumRepository;
import com.capstone.movieticketbooking.repository.MovieRepository;
import com.capstone.movieticketbooking.repository.TheatreRepository;
import com.capstone.movieticketbooking.services.MovieAuditoriumService;
import com.capstone.movieticketbooking.services.MovieService;
import com.capstone.movieticketbooking.services.TheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes({"movie","theatre"})
public class mainController {


public mainController(){
    System.out.println("main controller is being called.");
}

    @Autowired
    private MovieService movieService;

    @Autowired
    private TheatreService theatreService;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    AuditoriumRepository auditoriumRepository;

    @Autowired
    MovieAuditoriumService movieAuditoriumService;


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

    @RequestMapping(value = "/selectMovieAndTheatre", method = RequestMethod.GET)
    public String setMovieSchedule(Model model){
            List<Movie> movieList = movieService.getAllMovies();
            List<Theatre> theatreList = theatreService.getAllTheatres();
            model.addAttribute("movieList",movieList);
            model.addAttribute("theatreList",theatreList);




        return "selectMovieAndTheatre";

    }

    @GetMapping("/selectAuditoriumAndTimings")
    public String selectAuditoriumAndTimings(@ModelAttribute("movie") Movie movie,
                                             @ModelAttribute("theatre") Theatre theatre,
                                             Model model){
        System.out.println("in select Auditorium and Timings");


        List<Auditorium> auditoriumList = theatre.getAuditoriums();

        model.addAttribute("auditoriumList",auditoriumList);

        //movieauditorium stuff


        return "selectAuditoriumAndTimings";

    }





    /////////////POST/////////////////////////

    @PostMapping("/addMovie")
    public String processMovieDetails(@RequestParam("genre") String genre, @RequestParam("title") String title){

        System.out.println("inside addMovie");
        movieService.createMovie(genre,title);


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

    @PostMapping("/selectMovieAndTheatre")
    public String processMovieAndTheatre(@RequestParam("movieChosenTitle") String movieChosenTitle,
                                            @RequestParam("theatreChosenName") String theatreChosenName,
                                            Model model){

        Movie movie = movieRepository.findMovieByTitle(movieChosenTitle);
        Theatre theatre = theatreRepository.findTheatreByName(theatreChosenName);

        model.addAttribute("movie",movie);
        model.addAttribute("theatre",theatre);

        return "redirect:/selectAuditoriumAndTimings";
    }

    @PostMapping("/selectAuditoriumAndTimings")
    public String processAuditoriumAndTimings(@RequestParam("startTime") Double startTime,
                                              @RequestParam("endTime") Double endTime,
                                              @RequestParam("auditoriumChosenName") String auditoriumChosenName,
                                              @ModelAttribute("movie") Movie movie){
        System.out.println(movie);
        Auditorium auditorium = auditoriumRepository.findAuditoriumByName(auditoriumChosenName);

       MovieAuditorium movieAuditorium = movieAuditoriumService.processMovieAuditorium(movie, auditorium, startTime, endTime);
        System.out.println(movieAuditorium);
        return "redirect:/selectAuditoriumAndTimings";
    }
}
