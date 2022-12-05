package com.project.restapiboard.controller.page;

import com.project.restapiboard.configuration.auth.PrincipalDetails;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {

    @GetMapping("/")
    public String main(){
        return "main";
    }

    // OAuth 로그인을 해도 PrincipalDetails
    // 일반 로그인을 해도 PrincipalDetails
    @GetMapping("/user")
    public @ResponseBody  String user(@AuthenticationPrincipal PrincipalDetails principalDetails){
        System.out.println("principalDetails :" +principalDetails.getUser());
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

    @GetMapping("/test/login")
    public @ResponseBody String testLogin(Authentication authentication,
                                          @AuthenticationPrincipal PrincipalDetails userDetails){

        System.out.println("test/login =====================");
        PrincipalDetails principalDetails = (PrincipalDetails)authentication.getPrincipal();
        System.out.println("authentication :" +principalDetails.getUser());

        System.out.println("userDetails : " +userDetails.getUser());
        return "세션 정보 확인하기";
    }

    @GetMapping("/test/oauth/login")
    public @ResponseBody String testOAuthLogin(Authentication authentication,
                                               @AuthenticationPrincipal OAuth2User oAuth){

        System.out.println("test/oauth/login =====================");
        OAuth2User oAuth2User = (OAuth2User)authentication.getPrincipal();
        System.out.println("authentication :" +oAuth2User.getAttributes());

        System.out.println("oauth2User :" +oAuth.getAttributes());
        return "OAuth 세션 정보 확인하기";
    }



}
