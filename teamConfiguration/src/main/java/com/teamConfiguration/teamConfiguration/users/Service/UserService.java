package com.teamConfiguration.teamConfiguration.users.Service;

import com.teamConfiguration.teamConfiguration.users.Entity.user;
import com.teamConfiguration.teamConfiguration.users.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository  userRepository;

    @Autowired
    public UserService (UserRepository  userRepository){
        this.userRepository = userRepository;
    }

    public user getUsers(){
        return userRepository.findAll().get(0);
    }

    public void saveUser(user saveUser){
        userRepository.save(saveUser);
    }

    public void updateUser(Integer id, user updatedUser){
        Optional<user> existingUser = userRepository.findById(id);

        if (!existingUser.isEmpty()){
            user userToUpdate = existingUser.get();

            userToUpdate = updatedUser;

            userToUpdate.setId(id);
            userRepository.save(userToUpdate);
        }else{
            throw new NullPointerException("No user with provided id found : ");
        }
    }

    public void deleteUser(Integer id){
        Optional<user> existingUser = userRepository.findById(id);

        if (!existingUser.isEmpty()){
            user userToDelete = existingUser.get();
            userRepository.delete(userToDelete);
        }else{
            throw new NullPointerException("No user with provided id found : ");
        }
    }
}
