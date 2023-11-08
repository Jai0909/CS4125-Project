package com.kiss.carrentalsystem.service;
import com.kiss.carrentalsystem.dto.CarDTO;
import com.kiss.carrentalsystem.dto.UserDTO;
import com.kiss.carrentalsystem.dto.LoginDTO;
import com.kiss.carrentalsystem.response.CarResponse;
import com.kiss.carrentalsystem.response.LoginResponse;
import com.kiss.carrentalsystem.response.UserResponse;

public interface UserService {
    UserResponse addUser(UserDTO userDTO);
    LoginResponse loginUser(LoginDTO loginDTO);
    UserResponse updateName(UserDTO userDTO, String email);
    UserResponse updatePhone(UserDTO userDTO, String email);

    UserResponse updateAddress(UserDTO userDTO, String email);

    UserResponse updatePassword(UserDTO userDTO, String email);

}
