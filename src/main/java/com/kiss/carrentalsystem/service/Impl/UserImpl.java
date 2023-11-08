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
public class UserImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
    @Override
    public String addUser(UserDTO userDTO) {
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
        return user.getName();
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
    public UserResponse updateName(UserDTO userDTO, String input){
        User user2 = userRepo.findByEmail(userDTO.getEmail());
        if (user2 != null){
            user2.setName(input); //to be fixed
            userRepo.save(user2);
            return new UserResponse("Name change successful", true);
        }
        return new UserResponse("Name change failed", false);
    }

}