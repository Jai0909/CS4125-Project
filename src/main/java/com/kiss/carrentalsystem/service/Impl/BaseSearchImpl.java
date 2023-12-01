package com.kiss.carrentalsystem.service.Impl;

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

    @Override
    public List<String> searchByMakeModel(String toSearch) {
        List<Car> cars = carRepo.findByMakeModelContaining(toSearch);
        return extractLicensePlates(cars);
    }

    @Override
    public List<String> searchByType(String toSearch) {
        List<Car> cars = carRepo.findByVehicleType(toSearch);
        return extractLicensePlates(cars);
    }

    @Override
    public List<String> searchByMilage(int minMilage, int maxMilage) {
        List<Car> cars = carRepo.findByMilageBetween(minMilage, maxMilage);
        return extractLicensePlates(cars);
    }


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
