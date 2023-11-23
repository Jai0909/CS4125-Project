package com.kiss.carrentalsystem.config;

import com.kiss.carrentalsystem.factory.CarFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CarFactoryConfig {
    @Bean
    public CarFactory carFactory(){
        return new CarFactory();
    }

}
