package com.user.registration.controller;

import com.user.registration.dto.UserDTO;
import com.user.registration.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id){
        return ResponseEntity.ok().build();

    }

    @PostMapping("")
    public ResponseEntity<UserDTO> create(@RequestBody @Valid UserDTO userDTO){
        return ResponseEntity.ok(userService.create(userDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDTO> update(@PathVariable("id") Long id, @RequestBody @Valid UserDTO userDTO){
        return ResponseEntity.ok(userService.create(userDTO));
    }

}
