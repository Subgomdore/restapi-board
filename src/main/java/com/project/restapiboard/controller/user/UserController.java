package com.project.restapiboard.controller.user;

import com.project.restapiboard.entity.User;
import com.project.restapiboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
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
    public boolean idCheck(@RequestParam("userId") String userId){
        boolean cnt = userService.idCheck(userId);
        return cnt;
    }

    @GetMapping("/NickCheck")
    public User nickCheck(@RequestParam("nickName") String nickName){
         User user = userService.nickCheck(nickName);
        return user;
    }


}