package com.kiss.carrentalsystem.service.impl;
import com.kiss.carrentalsystem.dto.UserDTO;
import com.kiss.carrentalsystem.dto.LoginDTO;
import com.kiss.carrentalsystem.entity.User;
import com.kiss.carrentalsystem.repo.UserRepo;
import com.kiss.carrentalsystem.response.DefaultResponse;
import com.kiss.carrentalsystem.service.UserService;
import com.kiss.carrentalsystem.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserImpl implements UserService {
    UserValidator validator = new UserValidator();
    @Autowired
    private UserRepo userRepo;
    @Override
    public DefaultResponse addUser(UserDTO userDTO) {
        // This will create a new User entity from the UserDTO and it will be saved in the Database
        User user = new User(
                userDTO.getEmail(),
                userDTO.getName(),
                userDTO.getPassword(),
                userDTO.getPhoneNo(),
                userDTO.getAddress(),
                userDTO.getUserMilage(),
                userDTO.getDateOfBirth(),
                userDTO.isAdmin(),
                userDTO.getBalance()
        );
        userRepo.save(user);
        return new DefaultResponse("User added Successfully", true);
    }
    @Override
    public DefaultResponse loginUser(LoginDTO loginDTO) {
        // This is to find the user by email in the database
        User user1 = userRepo.findByEmail(loginDTO.getEmail());
        if (user1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
              if (password.equals(user1.getPassword())) {
                  // This checks if user with email and password exists
                Optional<User> user = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (user.isPresent()) {
                    return new DefaultResponse("Login Success", true);
                } else {
                    return new DefaultResponse("Login Failed", false);
                }
            } else {
                return new DefaultResponse("password Not Match", false);
            }
        }else {
            return new DefaultResponse("Email not exits", false);
        }
    }

    @Override
    public DefaultResponse addBalance(UserDTO userDTO, String email) {
        User user = userRepo.findByEmail(email);
        if (user != null) {
            DefaultResponse response = user.addBalance(userDTO.getBalance());
            userRepo.save(user);
            return response;
        } else {
            return new DefaultResponse("Failed to add money to balance", false);
        }
    }

    @Override
    public DefaultResponse removeBalance(UserDTO userDTO, String email) {
        User user = userRepo.findByEmail(email);
        if (user != null) {
            DefaultResponse response = user.removeBalance(userDTO.getBalance());
            userRepo.save(user);
            return response;
        } else {
            return new DefaultResponse("Failed to remove money from balance", false);
        }
    }


    @Override
    public DefaultResponse updateName(UserDTO userDTO, String email){
        User user = userRepo.findByEmail(email);
        if (user != null){
            if(validator.validateName(user.getName())) {
                user.setName(userDTO.getName());
                userRepo.save(user);
                return new DefaultResponse("Name changed successfully", true);
            } else {
                return new DefaultResponse("Name change failed, not allowed to use numbers", false);
            }
        }
        return new DefaultResponse("Name change failed, user not found", false);
    }

    public DefaultResponse updatePhone(UserDTO userDTO, String email){
        User user = userRepo.findByEmail(email);
        if (user != null){
            if(validator.validatePhone(user.getPassword())) {
                user.setPhoneNo(userDTO.getPhoneNo());
                userRepo.save(user);
                return new DefaultResponse("Phone Number changed successfully", true);
            } else {
                return new DefaultResponse("Phone number changed failed, not allowed letters", false);
            }
        }
        return new DefaultResponse("Phone Number change failed, user not found", false);
    }

    public DefaultResponse updateAddress(UserDTO userDTO, String email){
        User user = userRepo.findByEmail(email);
        if (user != null){
            user.setAddress(userDTO.getAddress());
            userRepo.save(user);
            return new DefaultResponse("Address changed successfully", true);
        }
        return new DefaultResponse("Address change failed, user not found", false);
    }

    public DefaultResponse updatePassword(UserDTO userDTO, String email){
        User user = userRepo.findByEmail(email);
        if (user != null){
            if(validator.validatePassword(user.getPassword())) {
                user.setPassword(userDTO.getPassword());
                userRepo.save(user);
                return new DefaultResponse("Password changed successfully", true);
            } else {
                return new DefaultResponse("Password does not match with our requirements\nPassword requires minumim 8 character, a capital letter and a number", false);
            }
        }
        return new DefaultResponse("Password change failed", false);
    }
}