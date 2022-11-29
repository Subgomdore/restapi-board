package com.project.restapiboard.controller.user;

import com.project.restapiboard.entity.User;
import com.project.restapiboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public List<User> getMemberList() {
        List<User> list = userService.getMemberList();
        return userService.getMemberList();
    }

    @PostMapping("/save")
    public void createUser(@RequestBody User user) {
        User saveUser = userService.save(user);
    }

    @PostMapping("/signIn")
    public User loginUser(@RequestBody User user) {
        User loginUser = userService.login(user);
        return loginUser;
    }


}