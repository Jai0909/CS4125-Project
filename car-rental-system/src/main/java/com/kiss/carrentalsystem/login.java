package com.kiss.carrentalsystem;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class login {
    @RequestMapping
    public String sayHi(){
        return "Hi";
    }
}
