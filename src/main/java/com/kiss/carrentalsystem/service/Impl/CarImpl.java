package com.kiss.carrentalsystem.service.Impl;

import com.kiss.carrentalsystem.dto.CarDTO;
import com.kiss.carrentalsystem.entity.Car;
import com.kiss.carrentalsystem.repo.CarRepo;
import com.kiss.carrentalsystem.response.DefaultResponse;
import com.kiss.carrentalsystem.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CarImpl implements CarService {

    @Autowired
    private CarRepo carRepo;

    @Override
    public DefaultResponse addCar(CarDTO carDTO) {
        Car car1 = new Car(carDTO.getMakeAndModel(),
                carDTO.getLicencePlate(),
                carDTO.getMilage(),
                carDTO.getVehicleType(),
                carDTO.isDamaged(),
                carDTO.getBasePrice(),
                carDTO.isAvailability()
        );
        carRepo.save(car1);
        return new DefaultResponse("Car added Successfully", true);
    }

    @Override
    public DefaultResponse deleteCar(CarDTO carDTO) {
        Car car2 = carRepo.findByLicencePlate(carDTO.getLicencePlate());
        if (car2 != null) {
            carRepo.delete(car2);
            return new DefaultResponse("Car deleted Successfully", true);
        } else {
            return new DefaultResponse("Car was not deleted", false);
        }
    }
}
