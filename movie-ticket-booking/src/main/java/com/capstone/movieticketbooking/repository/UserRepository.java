package com.capstone.movieticketbooking.repository;

import com.capstone.movieticketbooking.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    public User findUserByUsername(String username);
}
