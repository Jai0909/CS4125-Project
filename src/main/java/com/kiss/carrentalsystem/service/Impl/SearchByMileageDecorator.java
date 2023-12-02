package com.kiss.carrentalsystem.service.Impl;

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
        this.baseSearchService = baseSearchService;
    }

    @Override
    public List<String> searchByMakeModel(String toSearch) {
        return baseSearchService.searchByMakeModel(toSearch);
    }

    @Override
    public List<String> searchByType(String toSearch) {
        return baseSearchService.searchByType(toSearch);
    }

    @Override
    public List<String> searchByMilage(int milage) {
        List<Car> cars = carRepo.findByMilageGreaterThan(milage);
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