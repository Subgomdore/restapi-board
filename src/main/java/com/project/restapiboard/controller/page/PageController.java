package com.project.restapiboard.controller.page;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @GetMapping("/")
    public String main(){
        return "main";
    }
    @GetMapping("/user")
    public String user(){
        return "user";
    }
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
    @GetMapping("/manager")
    public String manager(){
        return "manager";
    }
    @GetMapping("/loginForm")
    public String loginForm(){
        return "LoginForm";
    }
    @GetMapping("/joinForm")
    public String joinForm(){
        return "user/UserJoinForm";
    }

    @Secured("ROLE_ADMIN")  // 간단하게 하나만 설정 하고 싶을때
    @GetMapping("/info")
    public @ResponseBody String info(){
        return "개인정보";
    }

    @PreAuthorize("hasRole('ROLE_MANAGER') or hasRole('ROLE_ADMIN')")   // 하나만 걸되 조건이 여러개이고 싶을떄
    @GetMapping("/data")
    public @ResponseBody String data(){
        return "데이터 정보";
    }
}
