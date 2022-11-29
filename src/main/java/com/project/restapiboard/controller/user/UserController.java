package com.project.restapiboard.controller.user;

import com.project.restapiboard.entity.User;
import com.project.restapiboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

    @PostMapping("/signin")
    public int loginUser(@RequestBody User user) {
        System.out.println("signin");
        int result = 0;

        System.out.println(user.getUser_id());
        System.out.println(user.getUser_pass());

        User loginUser = userService.login(user);
        if(user.getUser_id().equals(loginUser.getUser_id())){
            result =1;
            return result;
        }
        return result;
    }

    @PostMapping("/test")
    public String Test(){
        System.out.println("test");
        return "test";
    }


}