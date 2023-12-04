package com.kiss.carrentalsystem.service.impl;

import com.kiss.carrentalsystem.dto.CarDTO;
import com.kiss.carrentalsystem.dto.VanDTO;
import com.kiss.carrentalsystem.entity.Car;
import com.kiss.carrentalsystem.repo.CarRepo;
import com.kiss.carrentalsystem.response.DefaultResponse;
import com.kiss.carrentalsystem.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;

public class VanImpl implements CarService {
    @Autowired
    private CarRepo carRepo;

    @Override
    public DefaultResponse addCar(CarDTO carDTO) {
        // This is to check if the given CarDTO is an instance of VanDTO (this is specifically for vans)
        if(carDTO instanceof VanDTO) {
            // This will convert the CarDTO to VanDTO
            VanDTO vanDTO = (VanDTO)carDTO;
            // This will create a new Car entity from the VanDTO that will be saved to the Database
            Car car1 = new Car(vanDTO.getMakeModel(),
                    vanDTO.getLicencePlate(),
                    vanDTO.getMilage(),
                    vanDTO.getVehicleType(),
                    vanDTO.isDamaged(),
                    vanDTO.getBasePrice(),
                    vanDTO.isAvailability(),
                    vanDTO.getWeight()
            );
            carRepo.save(car1);
        }

        return new DefaultResponse("Van added Successfully", true);
    }

    @Override
    public DefaultResponse deleteCar(CarDTO carDTO) {
        // This will find the car by license plate
        Car car2 = carRepo.findByLicencePlate(carDTO.getLicencePlate());
        if (car2 != null) {
            carRepo.delete(car2); // This will delete the car from the Databse
            return new DefaultResponse("Car deleted Successfully", true);
        } else {
            return new DefaultResponse("Car was not deleted", false);
        }
    }

}
