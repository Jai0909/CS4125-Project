package com.kiss.carrentalsystem.service;

import com.kiss.carrentalsystem.dto.CarDTO;
import com.kiss.carrentalsystem.response.CarResponse;

public interface CarService {
    CarResponse addCar(CarDTO carDTO);

    CarResponse deleteCar(CarDTO carDTO);
}
