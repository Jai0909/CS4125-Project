package com.kiss.carrentalsystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kiss.carrentalsystem.dto.UserDTO;
import com.kiss.carrentalsystem.response.DefaultResponse;
import com.kiss.carrentalsystem.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(UserController.class)
@WebAppConfiguration
@AutoConfigureMockMvc
@AutoConfigureWebClient
public class UserControllerTest {
    private static final Logger logger = LoggerFactory.getLogger(UserControllerTest.class);

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private UserService userService;

    private ObjectMapper objectMapper;
    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build();
        this.objectMapper = new ObjectMapper();
    }

    @Test
    public void testPatchUserName() throws Exception {
        UserDTO user = new UserDTO();
        user.setName("test name");

        byte[] body = objectMapper.writeValueAsBytes(user);
        DefaultResponse defaultResponse = new DefaultResponse("good man", true);

        when(this.userService.updateName(any(), eq("test@sample.com"))).thenReturn(defaultResponse);
        this.mockMvc.perform(
                        patch("/user/updateName/test@sample.com")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(body))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("good man"))
                .andExpect(jsonPath("$.status").value(true));
    }

    @Test
    public void testPatchPhone() throws Exception {
        UserDTO user = new UserDTO();
        user.setName("test phone");

        byte[] body = objectMapper.writeValueAsBytes(user);
        DefaultResponse defaultResponse = new DefaultResponse("good man", true);

        when(this.userService.updateName(any(), eq("test@sample.com"))).thenReturn(defaultResponse);
        this.mockMvc.perform(
                        patch("/user/updateName/test@sample.com")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(body))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("good man"))
                .andExpect(jsonPath("$.status").value(true));
    }

    @Test
    public void testPatchAddress() throws Exception {
        UserDTO user = new UserDTO();
        user.setName("test address");

        byte[] body = objectMapper.writeValueAsBytes(user);
        DefaultResponse defaultResponse = new DefaultResponse("good man", true);

        when(this.userService.updateName(any(), eq("test@sample.com"))).thenReturn(defaultResponse);
        this.mockMvc.perform(
                        patch("/user/updateName/test@sample.com")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(body))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("good man"))
                .andExpect(jsonPath("$.status").value(true));
    }

    @Test
    public void testPatchPassword() throws Exception {
        UserDTO user = new UserDTO();
        user.setName("test password");

        byte[] body = objectMapper.writeValueAsBytes(user);
        DefaultResponse defaultResponse = new DefaultResponse("good man", true);

        when(this.userService.updateName(any(), eq("test@sample.com"))).thenReturn(defaultResponse);
        this.mockMvc.perform(
                        patch("/user/updateName/test@sample.com")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(body))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("good man"))
                .andExpect(jsonPath("$.status").value(true));
    }

    @Test
    public void testAddBalance() throws Exception {
        UserDTO user = new UserDTO();
        user.setName("test addBalance");

        byte[] body = objectMapper.writeValueAsBytes(user);
        DefaultResponse defaultResponse = new DefaultResponse("Success", true);

        when(this.userService.addBalance(any(), eq("test@sample.com"))).thenReturn(defaultResponse);
        this.mockMvc.perform(
                        patch("/user/addBalance/test@sample.com")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(body))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Success"))
                .andExpect(jsonPath("$.status").value(true));
    }

    @Test
    public void testRemoveBalance() throws Exception {
        UserDTO user = new UserDTO();
        user.setName("test removeBalance");

        byte[] body = objectMapper.writeValueAsBytes(user);
        DefaultResponse defaultResponse = new DefaultResponse("Success", true);

        when(this.userService.removeBalance(any(), eq("test@sample.com"))).thenReturn(defaultResponse);
        this.mockMvc.perform(
                        patch("/user/removeBalance/test@sample.com")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(body))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("Success"))
                .andExpect(jsonPath("$.status").value(true));
    }
}

