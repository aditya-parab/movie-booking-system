package com.capstone.movieticketbooking.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
public class mainController {

public mainController(){
    System.out.println("main controller is being called.");
}

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
    public String addMovie(){
        System.out.println("inside addMovie");

        return "addMovie";

    }

    @RequestMapping(value = "/addTheatre", method = RequestMethod.GET)
    public String addTheatre(){
        System.out.println("inside AddTheatre");

        return "addTheatre";

    }
}
