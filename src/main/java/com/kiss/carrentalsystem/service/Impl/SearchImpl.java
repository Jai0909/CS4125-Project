package com.kiss.carrentalsystem.service.Impl;


import com.kiss.carrentalsystem.entity.Car;
import com.kiss.carrentalsystem.repo.CarRepo;
import com.kiss.carrentalsystem.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchImpl implements SearchService {

    @Autowired
    private CarRepo carRepo;

    @Override
    public List<String> searchByMakeModel(String toSearch) {
        List<Car> cars = carRepo.findByMakeModelContaining(toSearch);
        List<String> result = new ArrayList<String>();
        if (cars != null) {
            for (Car car : cars) {
                result.add(car.getLicencePlate());
            }
        } else {
            System.out.println("No cars found for the given Make or Model: " + toSearch);
        }
        return result;
    }

    public List<String> searchByMilage(int minMilage, int maxMilage) {
        List<Car> cars = carRepo.findByMilageBetween(minMilage, maxMilage);
        List<String> result = new ArrayList<>();

        if (cars != null) {
            for (Car car : cars) {
                result.add(car.getLicencePlate());
            }
        } else {
            System.out.println("No cars found within the specified mileage range.");
        }

        return result;
    }

    public List<String> searchByType (String toSearch) {
        List<Car> cars = carRepo.findByVehicleType(toSearch);
        List<String> result = new ArrayList<>();

        if (cars != null) {
            for (Car car : cars) {
                result.add(car.getLicencePlate());
            }
        } else {
            System.out.println("No cars found for the given Vehicle type: " + toSearch);
        }

        return result;
    }

}
