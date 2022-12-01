package com.project.restapiboard.service;

import com.project.restapiboard.entity.User;
import com.project.restapiboard.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getMemberList() {
        return userRepository.findAll();
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public boolean idCheck(User user) {
        Optional<User> idCheck = userRepository.findById(user.getUser_id());
        return idCheck.isPresent();
    }

    public User login(User user) {
        Optional<User> loginUser = userRepository.findById(user.getUser_id());
        return loginUser.get();
    }

}
