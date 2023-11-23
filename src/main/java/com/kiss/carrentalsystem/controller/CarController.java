package com.kiss.carrentalsystem.controller;

import com.kiss.carrentalsystem.dto.CarDTO;
import com.kiss.carrentalsystem.factory.CarFactory;
import com.kiss.carrentalsystem.response.DefaultResponse;
import com.kiss.carrentalsystem.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("user")
public class CarController  {

    @Autowired
    private CarFactory carFactory;

    @PostMapping(path = "/addCar")
    public DefaultResponse addCar(@RequestBody CarDTO carDTO)
    {
        CarService carService = carFactory.getCarService(carDTO.getVehicleType());
        return carService.addCar(carDTO);
    }

    @PostMapping(path = "/deleteCar")
    public ResponseEntity<?> deleteCar(@RequestBody CarDTO carDTO) {
        CarService carService = carFactory.getCarService(carDTO.getVehicleType());
        DefaultResponse carResponse = carService.deleteCar(carDTO);
        return ResponseEntity.ok(carResponse);
    }
}
