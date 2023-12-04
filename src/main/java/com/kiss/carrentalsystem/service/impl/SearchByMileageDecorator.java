package com.kiss.carrentalsystem.service.impl;

import com.kiss.carrentalsystem.entity.Car;
import com.kiss.carrentalsystem.repo.CarRepo;
import com.kiss.carrentalsystem.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchByMileageDecorator implements SearchService {

    private final SearchService baseSearchService;
    private CarRepo carRepo;

    @Autowired
    public SearchByMileageDecorator(BaseSearchImpl baseSearchService) {
        this.baseSearchService = baseSearchService; // This injects the base SearchService
    }

    // This delegates the search make/model to the base SearchService
    @Override
    public List<String> searchByMakeModel(String toSearch) {
        return baseSearchService.searchByMakeModel(toSearch);
    }

    // This would delegate search by type to the base SearchService
    @Override
    public List<String> searchByType(String toSearch) {
        return baseSearchService.searchByType(toSearch);
    }

    // This is the Custom search by mileage greater than the value specified
    @Override
    public List<String> searchByMilage(int milage) {
        List<Car> cars = carRepo.findByMilageGreaterThan(milage);
        return extractLicensePlates(cars);
    }

    // This is the Utility method to extract the license plates from the list of cars
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