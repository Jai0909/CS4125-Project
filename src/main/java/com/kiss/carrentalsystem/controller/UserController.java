package com.kiss.carrentalsystem.controller;

import com.kiss.carrentalsystem.response.DefaultResponse;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.kiss.carrentalsystem.dto.UserDTO;
import com.kiss.carrentalsystem.dto.LoginDTO;
import com.kiss.carrentalsystem.service.UserService;
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
        public DefaultResponse saveUser(@RequestBody UserDTO userDTO)
        {
            return userService.addUser(userDTO);
        }
        @PostMapping(path = "/login")
        public ResponseEntity<?> loginEmployee(@RequestBody LoginDTO loginDTO)
        {
            DefaultResponse loginResponse = userService.loginUser(loginDTO);
            return ResponseEntity.ok(loginResponse);
        }

        @PatchMapping(path = "/updateName/{email}")
        public ResponseEntity<?> updateName(@RequestBody UserDTO userDTO, @PathVariable String email) {
            DefaultResponse userResponse = userService.updateName(userDTO, email);
            return ResponseEntity.ok(userResponse);
        }

        @PatchMapping(path = "/updatePhone/{email}")
        public ResponseEntity<?> updatePhone(@RequestBody UserDTO userDTO, @PathVariable String email) {
            DefaultResponse userResponse = userService.updatePhone(userDTO, email);
            return ResponseEntity.ok(userResponse);
        }

        @PatchMapping(path = "/updateAddress/{email}")
        public ResponseEntity<?> updateAddress(@RequestBody UserDTO userDTO, @PathVariable String email) {
            DefaultResponse userResponse = userService.updateAddress(userDTO, email);
            return ResponseEntity.ok(userResponse);
        }

        @PatchMapping(path = "/updatePassword/{email}")
        public ResponseEntity<?> updatePassword(@RequestBody UserDTO userDTO, @PathVariable String email) {
            DefaultResponse userResponse = userService.updatePassword(userDTO, email);
            return ResponseEntity.ok(userResponse);
        }

    }

