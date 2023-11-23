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
    public List<String> search(String toSearch) {
        List<Car> cars = carRepo.findByMakeModelContaining(toSearch);
        List<String> result = new ArrayList<String>();
        if (cars != null) {
            for (Car car : cars) {
                result.add(car.getLicencePlate());
            }
        } else {
            System.out.println("No cars found for search term: " + toSearch);
        }
        return result;
    }
}
