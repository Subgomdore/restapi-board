package com.project.restapiboard.controller.user;

import com.project.restapiboard.entity.User;
import com.project.restapiboard.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Slf4j
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
    public void saveUser(@RequestBody User user) {
        User saveUser = userService.save(user);
    }

    @PostMapping("/signin")
    public int loginUser(@RequestBody User user) {
        log.info(user.getUser_pass());
        int result = -1;
        User loginUser = userService.login(user);
        log.info(loginUser.getUser_pass());

        if(loginUser.getUser_pass().equals(user.getUser_pass())){
            result = 1;
            return result;
        }
        return result;
    }

    @PostMapping("/idCheck")
    public int idCheck(@RequestBody User user) {
        int result =0;
        if(userService.idCheck(user)){
            result =1;
            return result;
        }
        return result;
    }

}