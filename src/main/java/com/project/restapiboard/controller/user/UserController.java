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
        UserController.log.info("-----------------");
        UserController.log.info("singin-controller");
        int result = 0;

        User loginUser = userService.login(user);
        if(user.getUser_id().equals(loginUser.getUser_id())){
            result =1;
            return result;
        }
        return result;
    }

    @PostMapping("/test")
    public String Test(@RequestBody  String user_id, String user_pass){
        return "test";
    }


}