package com.kiss.carrentalsystem.service.impl;

import com.kiss.carrentalsystem.entity.Car;
import com.kiss.carrentalsystem.repo.CarRepo;
import com.kiss.carrentalsystem.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Primary
@Service
public class BaseSearchImpl implements SearchService {

    @Autowired
    private CarRepo carRepo;

    // This searches the cars by make or model containing the certain string
    @Override
    public List<String> searchByMakeModel(String toSearch) {
        List<Car> cars = carRepo.findByMakeModelContaining(toSearch);
        return extractLicensePlates(cars);
    }

    // This searches cars by the vehicle type
    @Override
    public List<String> searchByType(String toSearch) {
        List<Car> cars = carRepo.findByVehicleType(toSearch);
        return extractLicensePlates(cars);
    }

    // This searches cars by mileage grater than the value specified
    @Override
    public List<String> searchByMilage(int milage) {
        List<Car> cars = carRepo.findByMilageGreaterThan(milage);
        return extractLicensePlates(cars);
    }

    // This is the Utility method that extracts license plates from the list of cars
    private List<String> extractLicensePlates(List<Car> cars) {
        List<String> result = new ArrayList<>();
        if (cars != null) {
            for (Car car : cars) {
                result.add(car.getLicencePlate());
            }
        } else {
            System.out.println("No cars found for the given criteria.");
        }
        return result;
    }
}
