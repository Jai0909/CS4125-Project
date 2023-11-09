package com.kiss.carrentalsystem.service.Impl;
import com.kiss.carrentalsystem.dto.UserDTO;
import com.kiss.carrentalsystem.dto.LoginDTO;
import com.kiss.carrentalsystem.entity.User;
import com.kiss.carrentalsystem.repo.UserRepo;
import com.kiss.carrentalsystem.response.CarResponse;
import com.kiss.carrentalsystem.response.UserResponse;
import com.kiss.carrentalsystem.service.UserService;
import com.kiss.carrentalsystem.response.LoginResponse;
import com.kiss.carrentalsystem.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.xml.validation.Validator;
import java.util.Optional;
@Service
public class UserImpl implements UserService {
    UserValidator validator = new UserValidator();
    @Autowired
    private UserRepo userRepo;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
    @Override
    public UserResponse addUser(UserDTO userDTO) {
        User user = new User(
                userDTO.getEmail(),
                userDTO.getName(),
//                this.passwordEncoder.encode(userDTO.getPassword()),
                userDTO.getPassword(),
                userDTO.getPhoneno(),
                userDTO.getAddress(),
                userDTO.getUserMilage(),
                userDTO.getDateOfBirth()
        );
        userRepo.save(user);
        return new UserResponse("User added Successfully", true);
    }
    @Override
    public LoginResponse  loginUser(LoginDTO loginDTO) {
        User user1 = userRepo.findByEmail(loginDTO.getEmail());
        if (user1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
//            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
//            if (isPwdRight) {
              if (password.equals(user1.getPassword())) {
                Optional<User> user = userRepo.findOneByEmailAndPassword(loginDTO.getEmail(), encodedPassword);
                if (user.isPresent()) {
                    return new LoginResponse("Login Success", true);
                } else {
                    return new LoginResponse("Login Failed", false);
                }
            } else {
                return new LoginResponse("password Not Match", false);
            }
        }else {
            return new LoginResponse("Email not exits", false);
        }
    }


    @Override
    public UserResponse updateName(UserDTO userDTO, String email){
        User user = userRepo.findByEmail(email);
        if (user != null){
            if(validator.validateName(user.getName())) {
                user.setName(userDTO.getName());
                userRepo.save(user);
                return new UserResponse("Name changed successfully", true);
            } else {
                return new UserResponse("Name change failed, not allowed to use numbers", false);
            }
        }
        return new UserResponse("Name change failed, user not found", false);
    }

    public UserResponse updatePhone(UserDTO userDTO, String email){
        User user = userRepo.findByEmail(email);
        if (user != null){
            if(validator.validatePhone(user.getPassword())) {
                user.setPhoneno(userDTO.getPhoneno());
                userRepo.save(user);
                return new UserResponse("Phone Number changed successfully", true);
            } else {
                return new UserResponse("Phone number changed failed, not allowed letters", false);
            }
        }
        return new UserResponse("Phone Number change failed, user not found", false);
    }

    public UserResponse updateAddress(UserDTO userDTO, String email){
        User user = userRepo.findByEmail(email);
        if (user != null){
            user.setAddress(userDTO.getAddress());
            userRepo.save(user);
            return new UserResponse("Address changed successfully", true);
        }
        return new UserResponse("Address change failed, user not found", false);
    }

    public UserResponse updatePassword(UserDTO userDTO, String email){
        User user = userRepo.findByEmail(email);
        if (user != null){
            if(validator.validatePassword(user.getPassword())) {
                user.setPassword(userDTO.getPassword());
                userRepo.save(user);
                return new UserResponse("Password changed successfully", true);
            } else {
                return new UserResponse("Password does not match with our requirements\nPassword requires minumim 8 character, a capital letter and a number", false);
            }
        }
        return new UserResponse("Password change failed", false);
    }
}