package com.project.restapiboard.service;

import com.project.restapiboard.entity.User;
import com.project.restapiboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    private static List<User> users = new ArrayList<>();

    private static int usersCount = 3;

    public List<User> findAll() {
        return users;
    }
    public List<User> getMemberList(){
        return userRepository.findAll();
    }

    public User save(User user) {
        return  userRepository.save(user);
    }

    public User login(User user) {
        Optional<User> loginUser = userRepository.findByUserId(user.getUserId());
        if(!loginUser.isPresent()){
            return null;
        }
        loginUser.get().getUserId();
        return loginUser.get();
    }

}
