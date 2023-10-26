package com.kiss.carrentalsystem.Service.Impl;
import com.kiss.carrentalsystem.Dto.UserDTO;
import com.kiss.carrentalsystem.Dto.LoginDTO;
import com.kiss.carrentalsystem.Entity.User;
import com.kiss.carrentalsystem.Repo.UserRepo;
import com.kiss.carrentalsystem.Service.UserService;
import com.kiss.carrentalsystem.response.LoginResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;
@Service
public class UserImpl implements UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String addUser(UserDTO userDTO) {
        User user = new User(
                userDTO.getName(),
                userDTO.getEmail(),
                userDTO.getPhoneno(),
                userDTO.getAddress(),
                userDTO.getGender(),
                this.passwordEncoder.encode(userDTO.getPassword())
        );
        userRepo.save(user);
        return user.getName();
    }
    UserDTO userDTO;
    @Override
    public LoginResponse  loginUser(LoginDTO loginDTO) {
        User user1 = userRepo.findByEmail(loginDTO.getEmail());
        if (user1 != null) {
            String password = loginDTO.getPassword();
            String encodedPassword = user1.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
            if (isPwdRight) {
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
}