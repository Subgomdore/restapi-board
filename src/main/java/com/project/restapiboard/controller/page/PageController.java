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

    /*게시판타입 목록(일반, 거래, 질문게시판 등등) */
    @RequestMapping("/board/{typeNo}")
    public String boardList(@PathVariable long typeNo, Model model) {
        model.addAttribute("typeNo", typeNo);
        return "boardlist";
    }

    /*특정게시판의 글쓰기 페이지이동*/
    @RequestMapping("/board/{typeNo}/boardwrite")
    public String boardWrite(@PathVariable long typeNo, Model model) {
        System.out.println(typeNo);
        model.addAttribute("typeNo", typeNo);
        return "boardwrite";
    }

    /*특정게시판의 상세내용보기 페이지이동*/
    @RequestMapping("/board/{typeNo}/{boardNo}")
    public String boardContent(@PathVariable long typeNo, Model model) {
        System.out.println(typeNo);
        model.addAttribute("typeNo",typeNo);
        return "boardcontent";
    }
}
