package com.capstone.movieticketbooking.services;

import com.capstone.movieticketbooking.entities.User;
import com.capstone.movieticketbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User authenticateUser(String username, String password){
        User user = userRepository.findUserByUsername(username);
        if(user.getPassword().equals(password)){
            userRepository.save(user);
            return user;
        }
        else return null;
    }

}
