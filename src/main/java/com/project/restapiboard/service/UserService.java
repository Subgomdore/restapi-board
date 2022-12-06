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
        Optional<User> loginUser = userRepository.findById(user.getUser_id());
        return loginUser.get();
    }
    public User insert(User user) {
        // TODO Auto-generated method stub

        return  userRepository.save(user);
    }

    public long getCount() {
        // TODO Auto-generated method stub
        return userRepository.count();
    }

    public List<User> getList() {
        // TODO Auto-generated method stub
        return userRepository.findAll();
    }

    public User getContent(int user_no) {
        // TODO Auto-generated method stub
        return userRepository.findByNo(user_no);
    }

    public User update(User user) {
        // TODO Auto-generated method stub
        return userRepository.save(user);
    }

    public void delete(User user) {
        // TODO Auto-generated method stub
        userRepository.delete(user);
    }

}
