package com.kiss.carrentalsystem.service.Impl;
import com.kiss.carrentalsystem.dto.UserDTO;
import com.kiss.carrentalsystem.dto.LoginDTO;
import com.kiss.carrentalsystem.entity.User;
import com.kiss.carrentalsystem.repo.UserRepo;
import com.kiss.carrentalsystem.response.UserResponse;
import com.kiss.carrentalsystem.service.UserService;
import com.kiss.carrentalsystem.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class AdminImpl implements AdminService {
    @Autowired
    private AdminRepo adminRepo;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
    CarDTO carDTO;
    @Override
    public UserResponse addCar(CarDTO carDTO) {
        // Admin admin = carRepo.findByLicencePlate(carDTO.getLicencePlate());
        Car car = new Car(
                carDTO.getMakeAndModel(),
                userDTO.getLicencePlate(),
                userDTO.getMilage(),
                userDTO.getVehicleType(),
                userDTO.getBasePrice(),
        );
        carRepo.save(car);
        return new UserResponse("Car Added", true);
    }

     @Override
    public UserResponse deleteCar(String licensePlate) {
        Admin admin = carRepo.findByLicencePlate(licensePlate);
        if (car != null) {
            carRepo.delete(car);
            return new UserResponse("Car Deleted", true);
        }
        else {  
            return new UserResponse("Car cannot be deleted", false);
        }
    } 
}