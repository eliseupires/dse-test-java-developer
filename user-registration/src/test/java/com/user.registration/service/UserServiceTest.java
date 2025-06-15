package com.user.registration.service;

import com.user.registration.dto.UserDTO;
import com.user.registration.mapper.UserMapper;
import com.user.registration.model.User;
import com.user.registration.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    @Mock
    private UserRepository repository;
    @Mock
    private UserMapper userMapper;
    @InjectMocks
    private UserService service ;

    @Test
    void shouldRejectDuplicateEmail() {
        Mockito.when(repository.findByEmail("test@example.com"))
               .thenReturn(Optional.of(new User()));

        UserDTO user = new UserDTO();
        user.setName("Test");
        user.setEmail("test@example.com");

        assertThrows(IllegalStateException.class, () -> service.create(user));
    }

    @Test
    void shouldRejectInvalidEmail() {
        UserDTO user = new UserDTO();
        user.setName("Test");
        user.setEmail("invalid");

        assertThrows(IllegalArgumentException.class, () -> service.create(user));
    }

    @Test
    void shouldRejectEmptyName() {
        UserDTO user = new UserDTO();
        user.setEmail("test@example.com");

        assertThrows(IllegalArgumentException.class, () -> service.create(user));
    }
}
