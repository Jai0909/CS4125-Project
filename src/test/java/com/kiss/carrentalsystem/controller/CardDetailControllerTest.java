package com.kiss.carrentalsystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kiss.carrentalsystem.dto.CardDetailsDTO;
import com.kiss.carrentalsystem.response.DefaultResponse;
import com.kiss.carrentalsystem.service.CardDetailsService;
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(CardDetailsController.class)
@WebAppConfiguration
@AutoConfigureMockMvc
@AutoConfigureWebClient
public class CardDetailControllerTest {
    private static final Logger logger = LoggerFactory.getLogger(CarControllerTest.class);

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private CardDetailsService cardDetailsService;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build();
        this.objectMapper = new ObjectMapper();
    }


    @Test
    public void testAddCard() throws Exception {
        CardDetailsDTO card = new CardDetailsDTO();


        byte[] body = objectMapper.writeValueAsBytes(card);
        DefaultResponse defaultResponse = new DefaultResponse("good man", true);

        when(this.cardDetailsService.addCard(any())).thenReturn(defaultResponse);
        this.mockMvc.perform(
                        post("/card/saveCardDetails")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(body))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteCar() throws Exception {
        CardDetailsDTO card = new CardDetailsDTO();
        card.setCardNumber(12345678);

        byte[] body = objectMapper.writeValueAsBytes(card);
        DefaultResponse defaultResponse = new DefaultResponse("good man", true);

        when(this.cardDetailsService.deleteCard(any())).thenReturn(defaultResponse);
        this.mockMvc.perform(
                        post("/card/deleteCardDetails")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(body))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.message").value("good man"))
                .andExpect(jsonPath("$.status").value(true));
    }

}
