package com.user.registration.service;

import com.user.registration.dto.UserDTO;
import com.user.registration.mapper.UserMapper;
import com.user.registration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private  UserRepository repository;

    public UserDTO create(UserDTO user) {
       if (user.getName() == null || user.getEmail() == null)
          throw new IllegalArgumentException("Name and email are required");

        if (!Pattern.matches("^[A-Za-z0-9+_.-]+@(.+)$", user.getEmail()))
            throw new IllegalArgumentException("Invalid email format");

        repository.findByEmail(user.getEmail()).ifPresent(existing -> {
            throw new IllegalStateException("Email already in use");
        });

        return userMapper.toDto(repository.save(userMapper.toEntity((user))));
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    //public UserDTO update()
}
