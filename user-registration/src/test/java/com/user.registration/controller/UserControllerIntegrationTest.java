package com.user.registration.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.registration.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @WithMockUser(username = "user", roles = {"USER"})
    void testDeleteNotAllowedForUser() throws Exception {
        mockMvc.perform(delete("/api/users/1" ))
                .andExpect(status().isForbidden());
    }


    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void testDeleteAllowedForAdmin() throws Exception {
        mockMvc.perform(delete("/api/users/1" ))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void testCreateUserWithDuplicateEmail() throws Exception {
        User user1 = new User(  "pass1","duplicate@example.com");
        User user2 = new User( "pass2","duplicate@example.com");

        // First user should be created successfully
        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user1)))
                .andExpect(status().isOk());

        // Second user with same email should fail
        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user2)))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Email already in use")));
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void testCreateUserWithoutEmail() throws Exception {
        User user1 = new User(  "pass1", "");

        // First user should be created successfully
        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(user1)))
                .andExpect(status().isBadRequest());

    }
}
