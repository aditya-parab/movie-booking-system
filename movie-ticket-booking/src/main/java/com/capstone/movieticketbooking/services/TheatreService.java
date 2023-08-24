package com.capstone.movieticketbooking.services;

import com.capstone.movieticketbooking.entities.Auditorium;
import com.capstone.movieticketbooking.entities.Movie;
import com.capstone.movieticketbooking.entities.Seat;
import com.capstone.movieticketbooking.entities.Theatre;
import com.capstone.movieticketbooking.repository.AuditoriumRepository;
import com.capstone.movieticketbooking.repository.SeatRepository;
import com.capstone.movieticketbooking.repository.TheatreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreService {
    @Autowired
    TheatreRepository theatreRepository;

    @Autowired
    AuditoriumRepository auditoriumRepository;

    @Autowired
    SeatRepository seatRepository;

//    public Theatre processTheatre(String name, int noOfAuditoriums) {
//        Theatre theatre = new Theatre();
//        theatre.setName(name);
//        theatreRepository.save(theatre); // Save the theatre first
//
//        List<Auditorium> auditoriums = new ArrayList<>();
//        for (int i = 1; i <= noOfAuditoriums; i++) {
//            Auditorium auditorium = new Auditorium();
//            auditorium.setName("Auditorium " + i);
//            auditorium.setTheatre(theatre);
////            auditoriumRepository.save(auditorium);
//            List<Seat> seats = new ArrayList<Seat>();
//            for (int j = 0; j < 30; j++) { //create 30 seats for an auditorium
//                Seat seat = new Seat();
//                seat.setAuditorium(auditorium);
//                seatRepository.save(seat);
//                seats.add(seat);
//
//            }
//            auditoriums.add(auditorium);
//            auditoriumRepository.save(auditorium);
//        }
//        theatre.setAuditoriums(auditoriums);
//        theatreRepository.save(theatre);
//        return theatre;
//    }

    public List<Theatre> getAllTheatres() {
        return theatreRepository.findAll();
    }

    public Theatre processTheatre(String name, int noOfAuditoriums) {
        Theatre theatre = new Theatre();
        theatre.setName(name);

        theatreRepository.save(theatre); // Save the theatre first

        for (int i = 1; i <= noOfAuditoriums; i++) {
            Auditorium auditorium = new Auditorium();
            System.out.println(auditorium.getId());
            auditorium.setName("Auditorium " + i  +" - "+theatre.getName());
            auditorium.setTheatre(theatre);
            auditoriumRepository.save(auditorium); // Save the auditorium first

            List<Seat> seats = new ArrayList<>();
            for (int j = 0; j < 30; j++) { // Create 30 seats for an auditorium
                Seat seat = new Seat();
                seat.setAuditorium(auditorium);
                seats.add(seat);
            }

            seatRepository.saveAll(seats); // Save all seats after creating them
        }

        return theatre;
    }

}


