package com.project.restapiboard.service;

import com.project.restapiboard.entity.User;
import com.project.restapiboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getMemberList(){
        return userRepository.findAll();
    }

    public User save(User user) {
        System.out.println(user);
        return  userRepository.save(user);
    }

    public boolean idCheck(String user_id){
        return userRepository.existsById(user_id);
    }

}
