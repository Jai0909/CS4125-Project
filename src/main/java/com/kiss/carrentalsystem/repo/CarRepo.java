package com.kiss.carrentalsystem.repo;

import com.kiss.carrentalsystem.entity.Car;
import com.kiss.carrentalsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CarRepo extends JpaRepository<Car, Integer> {
    Car findByLicencePlate(String regNo);

//    Optional<Car> findOneBymake_and_model(String makeAndModel);
//    Optional<Car> findOneByVehicleType(String vehicleType);
//    Optional<Car> findOneByMilage(int milage);
//    Optional<Car> findOneByBasePrice(float price);
}