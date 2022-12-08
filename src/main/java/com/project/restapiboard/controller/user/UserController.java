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
        System.out.println(user.getUserId());
        System.out.println(user.getUserPw());
        log.info(user.getUserPw());
        int result = -1;
        User loginUser = userService.login(user);
        log.info(loginUser.getUserPw());

        if(loginUser.getUserPw().equals(user.getUserPw())){
            result = 1;
            log.info(Long.toString(result));
            return result;
        }
        log.info(Long.toString(result));
        return result;
    }


    }

