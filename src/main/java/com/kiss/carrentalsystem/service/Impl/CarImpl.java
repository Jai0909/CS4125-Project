package com.kiss.carrentalsystem.service.Impl;

import com.kiss.carrentalsystem.dto.CarDTO;
import com.kiss.carrentalsystem.entity.Car;
import com.kiss.carrentalsystem.entity.User;
import com.kiss.carrentalsystem.repo.CarRepo;
import com.kiss.carrentalsystem.response.CarResponse;
import com.kiss.carrentalsystem.response.LoginResponse;
import com.kiss.carrentalsystem.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CarImpl implements CarService {

    @Autowired
    private CarRepo carRepo;

    @Override
    public CarResponse addCar(CarDTO carDTO) {
        Car car1 = new Car(carDTO.getMakeAndModel(),
                carDTO.getLicencePlate(),
                carDTO.getMilage(),
                carDTO.getVehicleType(),
                carDTO.isDamaged(),
                carDTO.getBasePrice(),
                carDTO.isAvailability()
        );
        carRepo.save(car1);
        return new CarResponse("Car added Successfully", true);
    }

    @Override
    public CarResponse deleteCar(CarDTO carDTO) {
        Car car2 = carRepo.findByLicencePlate(carDTO.getLicencePlate());
        if (car2 != null) {
            carRepo.delete(car2);
            return new CarResponse("Car deleted Successfully", true);
        } else {
            return new CarResponse("Car was not deleted", false);
        }
    }
}
