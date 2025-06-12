package com.example.user.service;

import com.example.user.model.User;
import com.example.user.repository.UserRepository;
import java.util.regex.Pattern;

public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void registerUser(User user) {
        if (user.getName() == null || user.getEmail() == null)
            throw new IllegalArgumentException("Name and email are required");

        if (!Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", user.getEmail()))
            throw new IllegalArgumentException("Invalid email format");

        repository.findByEmail(user.getEmail()).ifPresent(existing -> {
            throw new IllegalStateException("Email already in use");
        });

        repository.save(user);
    }

    public void deleteUser(Long id, boolean isAdmin) {
        if (!isAdmin) {
            throw new SecurityException("Only admin users can delete");
        }
        repository.deleteById(id);
    }
}
