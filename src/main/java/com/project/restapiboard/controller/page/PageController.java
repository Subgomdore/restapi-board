package com.project.restapiboard.controller.page;

import com.project.restapiboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.*;

@Controller
public class PageController {

    @Autowired
    UserRepository userRepository;

    /*localhost:80 디폴트 맵핑경로*/
    @RequestMapping("/")
    public String loginForm() {
        return "loginform";
    }

    /*회원가입폼 이동*/
    @RequestMapping("/join")
    public String userJoin() {
        return "joinform";
    }

    /*게시판타입목록(일반,자유,거래 등등) 이동*/
    @RequestMapping("/board")
    public String boardTypeList() {
        return "boardtypelist";
    }


    @RequestMapping("/board/{boardtypeNo}")
    public String boardList(@PathVariable String boardtypeNo, Model model) {
        model.addAttribute("boardtypeNo", boardtypeNo);
        return "boardlist";
    }

    @RequestMapping("/board/{boardtypeNo}/boardwrite")
    public String boardWrite(@PathVariable String boardtypeNo, Model model){
        model.addAttribute("boardtypeNo", boardtypeNo);
        return "boardwrite";
    }
}
