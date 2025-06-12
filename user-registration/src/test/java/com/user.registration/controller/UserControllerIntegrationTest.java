package com.example.user.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void adminCanDeleteUser() throws Exception {
        mockMvc.perform(delete("/api/users/1")
                .header("Authorization", "Bearer ADMIN_TOKEN"))
                .andExpect(status().isOk());
    }

    @Test
    void nonAdminCannotDeleteUser() throws Exception {
        mockMvc.perform(delete("/api/users/1")
                .header("Authorization", "Bearer USER_TOKEN"))
                .andExpect(status().isForbidden());
    }
}
