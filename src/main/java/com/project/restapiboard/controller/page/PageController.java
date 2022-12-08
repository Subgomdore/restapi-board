package com.project.restapiboard.controller.page;

import com.project.restapiboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public String LoginForm(){
        return "loginform";
    }


    @RequestMapping("/boardform")
    public String UserJoinForm(){
        return "user/boardform";
    }

}
