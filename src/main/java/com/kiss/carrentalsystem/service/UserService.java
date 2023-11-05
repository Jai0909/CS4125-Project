package com.kiss.carrentalsystem.Service;
import com.kiss.carrentalsystem.Dto.UserDTO;
import com.kiss.carrentalsystem.Dto.LoginDTO;
import com.kiss.carrentalsystem.response.LoginResponse;
public interface UserService {
    String addUser(UserDTO userDTO);
    LoginResponse loginUser(LoginDTO loginDTO);
}
