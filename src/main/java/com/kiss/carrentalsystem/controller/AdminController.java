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
@RequestMapping("admin")
public class AdminController {
        @Autowired
        private AdminService adminService;
        @PostMapping(path = "/addCar")
        public ResponseEntity<?> addCar(@RequestBody CarDTO carDTO) {
            UserResponse adminResponse = adminService.addCar(carDTO);
            return ResponseEntity.ok(adminResponse);
        }

        @PostMapping(path = "/deleteCar/{licensePlate}")
        public ResponseEntity<?> deleteCar(@PathVariable String licensePlate) {
            UserResponse adminResponse = adminService.deleteCar(licensePlate);
            return ResponseEntity.ok(adminResponse);
        }
    }


