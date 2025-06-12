package com.example.user.repository;

import com.example.user.model.User;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findByEmail(String email);
    void save(User user);
    void deleteById(Long id);
    Optional<User> findById(Long id);
}
