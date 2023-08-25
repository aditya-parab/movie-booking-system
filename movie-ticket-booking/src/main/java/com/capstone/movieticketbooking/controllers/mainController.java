package com.capstone.movieticketbooking.controllers;

import com.capstone.movieticketbooking.entities.*;
import com.capstone.movieticketbooking.repository.AuditoriumRepository;
import com.capstone.movieticketbooking.repository.MovieRepository;
import com.capstone.movieticketbooking.repository.TheatreRepository;
import com.capstone.movieticketbooking.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@SessionAttributes({"movie","theatre","movieList","theatreList","filteredMovieAuditoriums","user"})
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

    @Autowired
    UserService userService;

    @Autowired
    BookingService bookingService;


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

    @GetMapping("/makeBookingSelectMovie")
    public String makeBookingSelectMovie(Model model){
        List<Movie> movieList = movieService.getAllMovies();

        model.addAttribute("movieList",movieList);

        return "makeBookingSelectMovie";
    }

    @GetMapping("makeBookingSelectTheatre")
    public String makeBookingSelectTheatre(@ModelAttribute("movie") Movie movie,
                                           Model model){
        System.out.println(movie);
        //show all theatres showing that movie, and the timings
        List<MovieAuditorium> movieAuditoriums = movie.getMovieAuditoriums();
        List<Theatre> theatreList = new ArrayList<>();
        for(MovieAuditorium movieAuditorium: movieAuditoriums){
            theatreList.add(movieAuditorium.getAuditorium().getTheatre());
        }

        model.addAttribute("theatreList",theatreList);



        return "makeBookingSelectTheatre";
    }

    @GetMapping("/selectBookingTime")
    public String selectBookingTimeAndNoOfSeats(@ModelAttribute("theatre") Theatre theatre,
                                                @ModelAttribute("movie") Movie movie,
                                                Model model){

        System.out.println(movie);
        System.out.println(theatre);
   List<MovieAuditorium> filteredMovieAuditoriums=  movie.getMovieAuditoriums()
                .stream()
                .filter(movieAuditorium -> movieAuditorium.getAuditorium().getTheatre().getName().equals(theatre.getName()))
           .collect(Collectors.toList());

        System.out.println(filteredMovieAuditoriums);

   List<String> startTimes=new ArrayList<>();
   for(MovieAuditorium movieAuditorium:filteredMovieAuditoriums){
       startTimes.add(movieAuditorium.getStartTime().toString());
   }

        System.out.println(startTimes);
   model.addAttribute("filteredMovieAuditoriums",filteredMovieAuditoriums);
   model.addAttribute("startTimes",startTimes);

        return "selectBookingTime";
    }


//    @GetMapping("/selectBookingSeats")
//    public String selectBookingSeats(@ModelAttribute("availableSeats") List<Seat> availableSeats,
//                                     Model model){
//        model.addAttribute("availableSeats",availableSeats);
//        return "selectBookingSeats";
//    }


    @GetMapping("/selectBookingSeats")
    public String selectBookingSeats(@ModelAttribute("availableSeats") List<Seat> availableSeats, Model model) {


        if (availableSeats != null) {
            model.addAttribute("availableSeats", availableSeats);
            return "selectBookingSeats";
        } else {
            // Handle the case where availableSeats is null
            // Redirect to an appropriate page or display an error message
            return "redirect:/selectBookingTime";
        }
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

    @PostMapping("/login")
    public String authenticateLogin(@RequestParam("username") String username,
                                    @RequestParam("password") String password,
                                    Model model){
        User user = userService.authenticateUser(username,password);
        model.addAttribute("user",user);
        if(user.getFirstName()==null){
            return "welcome";
        }




        return "redirect:/makeBookingSelectMovie";
    }

    @PostMapping("/makeBookingSelectMovie")
    public String processMakeBookingSelectMovie(@RequestParam("movieChosenTitle") String movieChosenTitle
    ,Model model){
        Movie movie = movieRepository.findMovieByTitle(movieChosenTitle);
        model.addAttribute("movie",movie);
        return "redirect:/makeBookingSelectTheatre";
    }

    @PostMapping("makeBookingSelectTheatre")
    public String processBookingSelectTheatre(@RequestParam("theatreChosenName") String theatreChosenName,
                                              Model model){
        Theatre theatre = theatreRepository.findTheatreByName(theatreChosenName);
        model.addAttribute("theatre",theatre);


        return "redirect:/selectBookingTime";
    }

//    @PostMapping("/selectBookingTime")
//    public String processBookingTime(@RequestParam("selectedStartTime") String selectedStartTime,
//                                     @ModelAttribute("filteredMovieAuditoriums") List<MovieAuditorium> filteredMovieAuditoriums,
//                                     Model model){
//        List<Seat> availableSeats = new ArrayList<>();
//        for(MovieAuditorium movieAuditorium:filteredMovieAuditoriums){
//            if(movieAuditorium.getStartTime().toString().equals(selectedStartTime)){
//                List<Seat> allSeats = movieAuditorium.getAuditorium().getSeats();
//                List<Seat> bookedSeats = new ArrayList<>();
//                for(Booking booking: movieAuditorium.getBookings()){
//                    bookedSeats.addAll(booking.getBookedSeats());
//                }
//                availableSeats.addAll(allSeats);
//                availableSeats.removeAll(bookedSeats);
//
//            }
//        }
//        System.out.println("BEFORE \n"+availableSeats);
//        model.addAttribute("availableSeats",availableSeats);
//        return "redirect:/selectBookingSeats";
//    }

    @PostMapping("/selectBookingTime")
    public String processBookingTime(@RequestParam("selectedStartTime") String selectedStartTime,
                                     @ModelAttribute("filteredMovieAuditoriums") List<MovieAuditorium> filteredMovieAuditoriums,
                                     RedirectAttributes redirectAttributes) {
        List<Seat> availableSeats = new ArrayList<>();
        for (MovieAuditorium movieAuditorium : filteredMovieAuditoriums) {
            if (movieAuditorium.getStartTime().toString().equals(selectedStartTime)) {
                List<Seat> allSeats = movieAuditorium.getAuditorium().getSeats();
                List<Seat> bookedSeats = new ArrayList<>();
                for (Booking booking : movieAuditorium.getBookings()) {
                    bookedSeats.addAll(booking.getBookedSeats());
                }
                availableSeats.addAll(allSeats);
                availableSeats.removeAll(bookedSeats);

                // Store availableSeats in RedirectAttributes
                redirectAttributes.addFlashAttribute("availableSeats", availableSeats);

                return "redirect:/selectBookingSeats";
            }
        }

        // Handle case where no valid MovieAuditorium was found
        return "redirect:/selectBookingTime"; // Redirect to an appropriate page
    }

    @PostMapping("selectBookingSeats")
    public String processBookingSeat(@RequestParam("seatChosen") Seat seatChosen,
                                     @ModelAttribute("user") User user,
                                     @ModelAttribute("movie") Movie movie,
                                     @ModelAttribute("theatre") Theatre theatre){

        bookingService.processBooking(seatChosen,  user,  movie, theatre);

        return "welcome";
    }

}
