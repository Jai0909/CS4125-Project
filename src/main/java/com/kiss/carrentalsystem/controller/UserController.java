package com.kiss.carrentalsystem.Controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kiss.carrentalsystem.Dto.UserDTO;
import com.kiss.carrentalsystem.Dto.LoginDTO;
import com.kiss.carrentalsystem.Service.UserService;
import com.kiss.carrentalsystem.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {

        @Autowired
        private UserService userService;
        @PostMapping(path = "/save")
        public String saveUser(@RequestBody UserDTO userDTO)
        {
            String id = userService.addUser(userDTO);
            return id;
        }
        @PostMapping(path = "/login")
        public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO)
        {
            LoginResponse loginResponse = userService.loginUser(loginDTO);
            return ResponseEntity.ok(loginResponse);
        }
    }

