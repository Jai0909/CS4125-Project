package com.kiss.carrentalsystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kiss.carrentalsystem.dto.BookingDTO;
import com.kiss.carrentalsystem.response.DefaultResponse;
import com.kiss.carrentalsystem.service.BookingService;
import com.kiss.carrentalsystem.service.impl.BasePDFGenerator;
import com.kiss.carrentalsystem.service.PDFGenerator;
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


import java.text.SimpleDateFormat;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest(BookingController.class)
@WebAppConfiguration
@AutoConfigureMockMvc
@AutoConfigureWebClient
public class BookingControllerTest {
    private static final Logger logger = LoggerFactory.getLogger(BookingControllerTest.class);

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private BookingService bookingService;

    private ObjectMapper objectMapper;


    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build();
        this.objectMapper = new ObjectMapper();
    }


    @Test
    public void testAddBooking() throws Exception {
        BookingDTO booking = new BookingDTO();


        byte[] body = objectMapper.writeValueAsBytes(booking);
        DefaultResponse defaultResponse = new DefaultResponse("good man", true);

        when(this.bookingService.addBooking(any())).thenReturn(defaultResponse);
        this.mockMvc.perform(
                        post("/booking/addBooking")
                                .contentType(MediaType.APPLICATION_JSON)
                                .accept(MediaType.APPLICATION_JSON)
                                .content(body))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testCancelBooking() throws Exception {
        BookingDTO booking = new BookingDTO();
        booking.setBookingId("123");

        byte[] body = objectMapper.writeValueAsBytes(booking);
        DefaultResponse defaultResponse = new DefaultResponse("good man", true);

        when(this.bookingService.cancelBooking(any())).thenReturn(defaultResponse);
        this.mockMvc.perform(
                        post("/booking/cancelBooking")
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
