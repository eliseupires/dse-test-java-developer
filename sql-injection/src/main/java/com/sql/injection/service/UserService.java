package com.sql.injection.service;

import com.sql.injection.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public boolean authenticate(String username, String password) {
        return repository.findByUsernameAndPassword(username, password).isPresent();
    }
}
