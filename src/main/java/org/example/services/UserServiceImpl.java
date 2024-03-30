package org.example.services;

import org.example.data.models.User;
import org.example.data.repositories.UserRepository;
import org.example.dtos.requests.LoginUserRequest;
import org.example.dtos.requests.LogoutUserRequest;
import org.example.dtos.requests.RegisterUserRequest;
import org.example.dtos.responses.RegisterUserResponse;
import org.example.exceptons.IncorrectUsernameException;
import org.example.exceptons.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static org.example.utils.Mapper.map;

@Service
public class UserServiceImpl implements  UserService {
    @Autowired
    private RegisterUserRequest registerUserRequest;
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoginUserRequest loginUserRequest;

    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest registerUserRequest) {
        registerUserRequest.setUsername(registerUserRequest.getUsername().toLowerCase());
        validate(registerUserRequest.getUsername());
        User user = map(registerUserRequest);
        RegisterUserResponse result = map(user);
        userRepository.save(user);
        return result;
    }

    @Override
    public Long count() {
        return userRepository.count();


    }

    @Override
    public void loginUser(LoginUserRequest loginUserRequest) {
        User user = userRepository.findByUsername(loginUserRequest.getUsername());
        if (user == null) throw new UserNotFoundException("user not found");
        if (!user.getUsername().equalsIgnoreCase(loginUserRequest.getUsername()) && user.getPassword().equalsIgnoreCase(loginUserRequest.getPassword()))
            throw new IncorrectUsernameException("invalid username or password");
        else {
            user.setLoginStatus(true);
        }
    }

    @Override
    public void logoutUser(LogoutUserRequest logoutUserRequest) {
        User user1 = userRepository.findByUsername(logoutUserRequest.getUsername());
        if (user1 == null) throw new UserNotFoundException("user not found");
        if(!user1.getUsername().equalsIgnoreCase(logoutUserRequest.getUsername())) throw  new IncorrectUsernameException("incorrect username ");
        else {
            user1.setLoginStatus(false);
            userRepository.save(user1);
        }
    }


    public void validate(String username) {
        boolean exists = userRepository.existsByUsername(username);
        if (exists) throw new UsernameExistException(String.format("%s already exist", username));

    }
}


