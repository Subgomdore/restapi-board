package com.project.restapiboard.controller.page;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {


    @RequestMapping("/")
    public String LoginForm(){
        return "loginform";
    }


    @RequestMapping("/userJoin")
    public String UserJoinForm(){return "user/UserJoinForm";}

}
