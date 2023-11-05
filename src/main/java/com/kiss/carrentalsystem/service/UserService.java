package com.kiss.carrentalsystem.service;
import com.kiss.carrentalsystem.dto.UserDTO;
import com.kiss.carrentalsystem.dto.LoginDTO;
import com.kiss.carrentalsystem.response.LoginResponse;
public interface UserService {
    String addUser(UserDTO userDTO);
    LoginResponse loginUser(LoginDTO loginDTO);
}
