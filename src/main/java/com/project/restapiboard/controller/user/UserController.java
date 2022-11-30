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

    @PostMapping("/signin")
    public int loginUser(@RequestBody User user) {
        System.out.println("signin");
        int result = -1;
        User loginUser = userService.login(user);
        if (user.getUser_pass().equals(loginUser.getUser_pass())) {
            result = 777;
            log.info("리턴성공" + result);
            return result;
        }
        log.info("리턴실패" + result);
        return result;
    }

    @PostMapping("/test")
    public String Test(@RequestBody String user_id, String user_pass) {
        return "test";
    }


}