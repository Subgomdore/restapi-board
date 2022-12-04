package com.project.restapiboard.controller.user;

import com.project.restapiboard.dto.request.RequestUserDto;
import com.project.restapiboard.dto.response.ResponseUserDto;
import com.project.restapiboard.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /*관리자용으로 추후 분리예정*/
    @GetMapping("/list")
    public List<ResponseUserDto> getUserList() {
//        List<ResponseUserDto> responseUserDtoList = userService.getUserList();
        return userService.getUserList();
    }

    /*회원가입 -> 유저등록*/
    @PostMapping("/save")
    public void saveUser(@RequestBody RequestUserDto requestUserDto) {
        userService.save(requestUserDto);
    }

    /*로그인: 비밀번호 조회 후 return */
    @PostMapping("/signin")
    public int loginCheck(@RequestBody RequestUserDto requestUserDto, HttpServletRequest request) {
        int result = -1;
        ResponseUserDto loginUser = userService.loginCheck(requestUserDto);

        if (requestUserDto.getUser_pass().equals(loginUser.getUser_pass())) { // tru
            result = 1;

            /*추후 인터셉터 변경 및 쿠키값으로 수정예정*/
            HttpSession session = request.getSession();
            session.setAttribute("sessionid", requestUserDto.getUser_id());


            return result;
        }
        return result;
    }

    @PostMapping("/idCheck")
    public int idCheck(@RequestBody RequestUserDto requestUserDto) {
        int result = 0;
        if (userService.idCheck(requestUserDto)) {
            result = 1;
            return result;
        }
        return result;
    }

}