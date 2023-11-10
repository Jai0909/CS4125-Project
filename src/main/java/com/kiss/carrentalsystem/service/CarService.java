package com.kiss.carrentalsystem.service;

import com.kiss.carrentalsystem.dto.CarDTO;
import com.kiss.carrentalsystem.response.DefaultResponse;

public interface CarService {
    DefaultResponse addCar(CarDTO carDTO);

    DefaultResponse deleteCar(CarDTO carDTO);
}
