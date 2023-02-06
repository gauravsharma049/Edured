package com.company.edured.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Userservice {
    @Autowired
    UserRepository userRepository;
    public User getUserById(int id){
        return userRepository.getById(id);
    }
    public User getUserbyusername(String username){
        User user = userRepository.getUserByUsername(username);
        return user;
    }
    public User UserSignUp(User user){
        return userRepository.save(user);
    }
}
