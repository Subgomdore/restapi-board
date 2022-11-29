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

    public List<User> getMemberList() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User login(User user) {

        userRepository.findById(user.getUser_id());
        // userRepository.findById(user.getUser_id()); 를 선행처리하지 않으면 Exception 발생
        return userRepository.getReferenceById(user.getUser_id());
    }

}
