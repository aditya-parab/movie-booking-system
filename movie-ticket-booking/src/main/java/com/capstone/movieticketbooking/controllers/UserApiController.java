package com.capstone.movieticketbooking.controllers;


import com.capstone.movieticketbooking.entities.Booking;
import com.capstone.movieticketbooking.entities.User;
import com.capstone.movieticketbooking.repository.BookingRepository;
import com.capstone.movieticketbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserApiController {
    @Autowired
    UserRepository userRepository;

    @Autowired
    BookingRepository bookingRepository;


    //get all users
    public List<User> getAllUsers(){
        List<User> users = userRepository.findAll();
        return users;

    }

    //cancel a booking for a user
    @GetMapping("/{userId}/bookings/{bookingId}")
    @ResponseStatus(HttpStatus.OK)
    public void cancelBookingUser(@PathVariable Long userId, @PathVariable Long bookingId){
        Optional<User> userOptional = userRepository.findById(userId);
        Optional<Booking> bookingOptional = bookingRepository.findById(bookingId);
        if(userOptional.isPresent() && bookingOptional.isPresent()){
            User user = userOptional.get();
            Booking booking = bookingOptional.get();

            if(booking.getUser().equals(user)){
                booking.setActive(false);
            }
        }

    }
}
