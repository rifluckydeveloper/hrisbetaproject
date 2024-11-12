package com.example.hrisproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrisproject.model.Users;
import com.example.hrisproject.repository.UserRepository;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Fungsi autentikasi dengan plain-text password
    public Optional<Users> authenticateUser(String username, String password) {
        Optional<Users> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            Users users = userOptional.get();
            // Periksa apakah password cocok (plain text)
            if (password.equals(users.getPassword())) {
                return Optional.of(users);
            }
        }
        return Optional.empty();
    }

    // Fungsi untuk mendaftarkan user dengan password dalam bentuk plain-text
    public void registerUser(Users users) {
        userRepository.save(users);
    }
}

