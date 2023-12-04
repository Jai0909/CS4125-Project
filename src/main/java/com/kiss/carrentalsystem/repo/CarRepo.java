package com.kiss.carrentalsystem.repo;

import com.kiss.carrentalsystem.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface CarRepo extends JpaRepository<Car, Integer> {
    Car findByLicencePlate(String regNo);

    List<Car> findByMakeModelContaining(String toSearch);

    List<Car> findByMilageGreaterThan(int milage);

    List<Car> findByVehicleType(String toSearch);

//    Optional<Car> findOneBymake_and_model(String makeAndModel);
//    Optional<Car> findOneByVehicleType(String vehicleType);
//    Optional<Car> findOneByMilage(int milage);
//    Optional<Car> findOneByBasePrice(float price);

}
