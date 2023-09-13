package com.teamConfiguration.teamConfiguration.users.Service;

import com.teamConfiguration.teamConfiguration.users.Entity.user;
import com.teamConfiguration.teamConfiguration.users.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthenticationService {

    private final UserRepository userRepository;

    @Autowired
    public AuthenticationService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<user> findUser(String email, String password){
        List<user> existingUser = userRepository.findByEmailAndPassword(email,password);

        if (existingUser.isEmpty()){
            throw new IllegalArgumentException("Incorrect email or password");
        }
        return existingUser;
    }
}
