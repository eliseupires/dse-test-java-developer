package com.example.user.service;

import com.example.user.model.User;
import com.example.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class UserServiceTest {
    private final UserRepository repo = Mockito.mock(UserRepository.class);
    private final UserService service = new UserService(repo);

    @Test
    void shouldRejectDuplicateEmail() {
        Mockito.when(repo.findByEmail("test@example.com"))
               .thenReturn(Optional.of(new User()));

        User user = new User();
        user.setName("Test");
        user.setEmail("test@example.com");

        assertThrows(IllegalStateException.class, () -> service.registerUser(user));
    }

    @Test
    void shouldRejectInvalidEmail() {
        User user = new User();
        user.setName("Test");
        user.setEmail("invalid");

        assertThrows(IllegalArgumentException.class, () -> service.registerUser(user));
    }
}
