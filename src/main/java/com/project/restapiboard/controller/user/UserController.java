package com.project.restapiboard.controller.user;

import com.project.restapiboard.dto.request.ReqUserDto;
import com.project.restapiboard.dto.response.ResUserDto;
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
    public List<ResUserDto> getUserList() {
//        List<ResponseUserDto> responseUserDtoList = userService.getUserList();
        return userService.getUserList();
    }

    /*ID중복체크 */
    @PostMapping("/idCheck")
    public int idCheck(@RequestBody ReqUserDto reqUserDto) {
        int result = 0;
        if (userService.idCheck(reqUserDto)) {
            result = 1;
            return result;
        }
        return result;
    }

    /*회원가입 -> 유저등록*/
    @PostMapping("/save")
    public void saveUser(@RequestBody ReqUserDto reqUserDto) {
        userService.save(reqUserDto);
    }

    /*로그인: 비밀번호 조회 후 return */
    @PostMapping("/signin")
    public int loginCheck(@RequestBody ReqUserDto reqUserDto, HttpServletRequest request) {
        System.out.println(reqUserDto.getUserId());
        System.out.println(reqUserDto.getUserPass());
        int result = -1;
        ResUserDto loginUser = userService.loginCheck(reqUserDto);

        if (reqUserDto.getUserPass().equals(loginUser.getUserPass())) { // tru
            result = 1;

            /*추후 인터셉터 변경 및 쿠키값으로 수정예정*/
            HttpSession session = request.getSession();
            session.setAttribute("sessionid", reqUserDto.getUserId());


            return result;
        }
        return result;
    }


}