package com.project.restapiboard.controller.user;

import com.project.restapiboard.entity.User;
import com.project.restapiboard.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> retrieveAllUsers() {
        return userService.findAll();
    }

    @GetMapping("/list")
    public List<User> getMemberList() {
        List<User> list = userService.getMemberList();
        return userService.getMemberList();
    }

    @PostMapping("/save")
    public void createUser(@RequestBody User user) {
        User saveUser = userService.save(user);

    }

    @PostMapping("/signin")
    public int loginUser(@RequestBody User user) {
        log.info(user.getUser_password());
        int result = -1;
        User loginUser = userService.login(user);
        log.info(loginUser.getUser_password());

        if(loginUser.getUser_password().equals(user.getUser_password())){
            result = 1;
            return result;
        }
        return result;
    }

    }

