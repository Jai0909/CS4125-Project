package com.kiss.carrentalsystem.service;

import com.kiss.carrentalsystem.dto.CarDTO;
import com.kiss.carrentalsystem.response.CarResponse;

public interface CarService {
    String addCar(CarDTO carDTO);

    CarResponse deleteCar(CarDTO carDTO);
}
