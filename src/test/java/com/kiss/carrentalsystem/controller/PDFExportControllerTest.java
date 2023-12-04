package com.kiss.carrentalsystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kiss.carrentalsystem.dto.BookingDTO;
import com.kiss.carrentalsystem.entity.Car;
import com.kiss.carrentalsystem.entity.User;
import com.kiss.carrentalsystem.service.PDFGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.AutoConfigureWebClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PDFExportController.class)
@WebAppConfiguration
@AutoConfigureMockMvc
@AutoConfigureWebClient
public class PDFExportControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @MockBean
    private PDFGenerator pdfGeneratorService;

    private ObjectMapper objectMapper;

    @BeforeEach
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        this.objectMapper = new ObjectMapper();
    }

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    @Test
    public void testGeneratePDF() throws Exception {
        // This mocks the car entity
        Car car = new Car();
        car.setMakeModel("Toyota Camry");
        car.setDamaged(false);
        car.setMilage(300);
        car.setVehicleType("car");
        car.setBasePrice(400);
        car.setAvailability(true);
        car.setLicencePlate("1234");

        User user = new User();
        user.setEmail("user@example.com");
        user.setDateOfBirth("2001-09-09");
        user.setUserMilage(100);
        user.setPhoneNo("0894947430");
        user.setBalance(500);
        user.setName("user");
        user.setAdmin(true);
        user.setAddress("limerick");
        user.setPassword("test@1234");

        // The BookingDTO is created with the mocked car and user
        BookingDTO bookingDTO = new BookingDTO(car, user, "123", new Date(), new Date());

        // Now the HttpServletResponse will be mocked
        MockHttpServletResponse response = new MockHttpServletResponse();

        // So the Behaviour of PDF Generator is mocked
        doNothing().when(pdfGeneratorService).generateBookingPDF(response, bookingDTO);

        this.mockMvc.perform(
                        get("/pdf/generate")
                                .contentType(MediaType.APPLICATION_JSON)
                                .param("bookingDTO", objectMapper.writeValueAsString(bookingDTO)))
                .andDo(print())
                .andExpect(status().isOk());

        // This verifies that the generateBookingPDF method is called from the PDFGenerator
        verify(pdfGeneratorService).generateBookingPDF(response, bookingDTO);
    }
}