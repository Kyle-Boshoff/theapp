package com.teamConfiguration.teamConfiguration.Controller;

import com.teamConfiguration.teamConfiguration.users.Dto.loginDetails;
import com.teamConfiguration.teamConfiguration.users.Entity.Team;
import com.teamConfiguration.teamConfiguration.users.Entity.user;
import com.teamConfiguration.teamConfiguration.users.Repository.TeamRepository;
import com.teamConfiguration.teamConfiguration.users.Repository.UserRepository;
import com.teamConfiguration.teamConfiguration.users.Service.AuthenticationService;
import com.teamConfiguration.teamConfiguration.users.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController {


    private final UserRepository userRepository;

    private final UserService userService;

    private final AuthenticationService authenticationService;
    private final TeamRepository teamRepository;
    @Autowired
    public UserController(
                          UserRepository userRepository, TeamRepository teamRepository,
                          UserService userService,AuthenticationService authenticationService){
        this.userRepository = userRepository;
        this.teamRepository = teamRepository;
        this.userService = userService;
        this.authenticationService = authenticationService;

    }

    @GetMapping("/getUsers")
    public List<user> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/getTeams")
    public List<Team> getAllTeams(){
        return teamRepository.findAll();
    }

    @PostMapping("addUser")
    public String addUser(@RequestBody user saveUser){
        try{
            userRepository.save(saveUser);

            return "User saved successfully";
        }catch (Exception e){
            throw new IllegalArgumentException("There was a problem while saving user" +  e.getMessage());
        }
    }

    @PutMapping("updateUser/{id}")
    public String updateUser(@PathVariable Integer id, @RequestBody user updateUser){
        try{
            userService.updateUser(id,updateUser);

            return "User updated successfully";
        }catch (Exception e){
            throw new IllegalArgumentException("User with the provided id does not exist" +  e.getMessage());
        }
    }

    @DeleteMapping("deleteUser/{id}")
    public String deleteUser(@PathVariable Integer id){
        try{
            userService.deleteUser(id);

            return "User deleted successfully";
        }catch (Exception e){
            throw new IllegalArgumentException("User with the provided id does not exist" +  e.getMessage());
        }
    }

    @PostMapping("login")
    public ResponseEntity<?> logUserIn(@RequestBody loginDetails loginDetails){
        try {
            return ResponseEntity.ok(authenticationService.findUser(loginDetails.getEmail(), loginDetails.getPassword()));
        }catch (Exception e){
            String message = e.getMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);

        }
    }
}
