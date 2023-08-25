package com.capstone.movieticketbooking.services;

import com.capstone.movieticketbooking.entities.*;
import com.capstone.movieticketbooking.entities.Seat;
import com.capstone.movieticketbooking.entities.User;
import com.capstone.movieticketbooking.repository.BookingRepository;
import com.capstone.movieticketbooking.repository.MovieAuditoriumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    MovieAuditoriumRepository movieAuditoriumRepository;

    public Booking processBooking(Seat seat, User user, Movie movie,Theatre theatre){
        Booking booking = new Booking();
        booking.setActive(true);
        booking.setUser(user);
        List<Seat> bookedSeats= new ArrayList<>();
        bookedSeats.add(seat);
        booking.setBookedSeats(bookedSeats);
        for(MovieAuditorium movieAuditorium: movie.getMovieAuditoriums()){
            if(movieAuditorium.getMovie().getTitle().equals(movie.getTitle())){
                booking.setMovieAuditorium(movieAuditorium);
                movieAuditorium.getBookings().add(booking);
                movieAuditoriumRepository.save(movieAuditorium);
                bookingRepository.save(booking);
            }

        }





        return booking;
    }
}
