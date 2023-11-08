package com.kiss.carrentalsystem.controller;

import com.kiss.carrentalsystem.response.UserResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kiss.carrentalsystem.dto.UserDTO;
import com.kiss.carrentalsystem.dto.LoginDTO;
import com.kiss.carrentalsystem.service.UserService;
import com.kiss.carrentalsystem.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("user")
public class UserController {

        @Autowired
        private UserService userService;
        @PostMapping(path = "/save")
        public UserResponse saveUser(@RequestBody UserDTO userDTO)
        {
            return userService.addUser(userDTO);
        }
        @PostMapping(path = "/login")
        public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO)
        {
            LoginResponse loginResponse = userService.loginUser(loginDTO);
            return ResponseEntity.ok(loginResponse);
        }

        @PatchMapping(path = "/updateName/{email}")
        public ResponseEntity<?> updateName(@RequestBody UserDTO userDTO, @PathVariable String email) {
            UserResponse userResponse = userService.updateName(userDTO, email);
            return ResponseEntity.ok(userResponse);
        }
    }

