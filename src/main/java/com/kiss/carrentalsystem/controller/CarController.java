package com.kiss.carrentalsystem.controller;

import com.kiss.carrentalsystem.dto.LoginDTO;
import com.kiss.carrentalsystem.dto.CarDTO;
import com.kiss.carrentalsystem.response.CarResponse;
import com.kiss.carrentalsystem.response.LoginResponse;
import com.kiss.carrentalsystem.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("user")
public class CarController  {

    @Autowired
    private CarService carService;
    @PostMapping(path = "/addCar")
    public CarResponse addCar(@RequestBody CarDTO carDTO)
    {
        return carService.addCar(carDTO);
    }
    @PostMapping(path = "/deleteCar")
    public ResponseEntity<?> deleteCar(@RequestBody CarDTO carDTO) {
        CarResponse carResponse = carService.deleteCar(carDTO);
        return ResponseEntity.ok(carResponse);
    }
}
