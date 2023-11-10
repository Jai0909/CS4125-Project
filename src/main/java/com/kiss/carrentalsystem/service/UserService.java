package com.kiss.carrentalsystem.service;
import com.kiss.carrentalsystem.dto.UserDTO;
import com.kiss.carrentalsystem.dto.LoginDTO;
import com.kiss.carrentalsystem.response.DefaultResponse;

public interface UserService {
    DefaultResponse addUser(UserDTO userDTO);
    DefaultResponse loginUser(LoginDTO loginDTO);
    DefaultResponse updateName(UserDTO userDTO, String email);
    DefaultResponse updatePhone(UserDTO userDTO, String email);

    DefaultResponse updateAddress(UserDTO userDTO, String email);

    DefaultResponse updatePassword(UserDTO userDTO, String email);

}
