package com.sql.injection;

import com.sql.injection.model.User;
import com.sql.injection.repository.UserRepository;
import com.sql.injection.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @BeforeEach
    public void setup() {
        userRepository.deleteAll();
        User user = new User();
        user.setId(1L);
        user.setUsername("john");
        user.setPassword("pass123");
        userRepository.save(user);
    }

    @Test
    public void testAuthenticationSuccess() {
        assertTrue(userService.authenticate("john", "pass123"));
    }

    @Test
    public void testAuthenticationFailure() {
        assertFalse(userService.authenticate("john", "wrongpass"));
    }

    @Test
    public void testSQLInjectionAttempt() {
        String maliciousUsername = "john' OR '1'='1";
        String maliciousPassword = "anything";
        assertFalse(userService.authenticate(maliciousUsername, maliciousPassword));
    }
}
