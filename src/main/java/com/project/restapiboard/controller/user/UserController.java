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
    public User createUser(@RequestBody User user) {
        User saveUser = userService.save(user);
        return saveUser;
    }
    @GetMapping("/IdCheck")
    public boolean idCheck(@RequestParam("user_id") String user_id){
        boolean cnt = userService.idCheck(user_id);
        return cnt;
    }


}