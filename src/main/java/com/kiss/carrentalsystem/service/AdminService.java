package com.kiss.carrentalsystem.service;
import com.kiss.carrentalsystem.dto.UserDTO;
import com.kiss.carrentalsystem.dto.LoginDTO;
import com.kiss.carrentalsystem.response.LoginResponse;
import com.kiss.carrentalsystem.response.UserResponse;

public interface AdminService {
    UserResponse addCar(CarDTO carDTO);
    UserResponse deleteCar(String licensePlate);
}
