package com.kiss.carrentalsystem.factory;

import com.kiss.carrentalsystem.service.CarService;
import com.kiss.carrentalsystem.service.Impl.CarImpl;
import com.kiss.carrentalsystem.service.Impl.VanImpl;

public class CarFactory {
    public CarService getCarService(String vehicleType){
        if(vehicleType.equalsIgnoreCase("CAR")){
            return new CarImpl();
        } else if(vehicleType.equalsIgnoreCase("VAN")){
            return new VanImpl();
        }
        return null;
    }
}
