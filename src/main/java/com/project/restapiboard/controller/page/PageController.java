package com.project.restapiboard.controller.page;

import com.project.restapiboard.entity.User;
import com.project.restapiboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping("/")
    public String LoginForm() {
        return "loginform";
    }

    @RequestMapping("/join")
    public String UserJoin() {
        return "joinform";
    }

    @RequestMapping("/jointest")
    public String test() {
        return "jointest";
    }

    @RequestMapping("/boardlist")
    public String BoardList() {
        return "boardlist";
    }

//    @RequestMapping("/signin")
//    public String signIn(User user) {
//        String userPw = userRepository.findById(user.getUser_id()).get().getUser_pass();
//        if (user.getUser_pass().equals(userPw)) {
//            return "redirect:/boardlist";
//        }
//        return "redirect:/";
//    }

}
