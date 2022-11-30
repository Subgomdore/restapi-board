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
        log.info(user.getUser_pass());
        int result = -1;
        User loginUser = userService.login(user);
        log.info(loginUser.getUser_pass());
        return result;
    }

    @PostMapping("/idCheck")
    public int idCheck(@RequestBody User user) throws Exception {
        User idCheck = userService.idCheck(user);
        int result = -44;
        if(idCheck.getUser_id().equals(user.getUser_id())){
            result = 0;
            return result;
        }
        return result;
    }

}