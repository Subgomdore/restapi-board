package com.project.restapiboard.controller.page;

import com.project.restapiboard.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class PageController {

    @Autowired
    UserRepository userRepository;

    /*localhost:80 디폴트 맵핑경로*/
    @RequestMapping("/")
    public String loginForm() {
        log.info("/");
        return "loginform";
    }

    /*회원가입폼 이동*/
    @RequestMapping("/join")
    public String userJoin() {
        log.info("/join");
        return "joinform";
    }

    /*게시판타입목록(일반,자유,거래 등등) 이동*/
    @RequestMapping("/board")
    public String boardTypeList()
    {   log.info("/board");
        return "boardtypelist";
    }

    /*특정게시판안의 리스트 불러오기*/
    @RequestMapping("/board/{typeNo}")
    public String boardList(@PathVariable long typeNo, Model model) {
        log.info("/board/{typeNo}");
        int page = 0;

        model.addAttribute("typeNo", typeNo);
        model.addAttribute("page", page);
        return "boardlist";
    }

    /*특정게시판의 글쓰기 페이지이동*/
    @RequestMapping("/board/{typeNo}/boardwrite")
    public String boardWrite(@PathVariable long typeNo, Model model) {
        log.info("/board/{typeNo}/boardwrite");
        model.addAttribute("typeNo", typeNo);
        return "boardwrite";
    }

    /*특정게시판의 상세내용보기 페이지이동*/
    @GetMapping("/board/{typeNo}/{boardNo}")
    public String boardContent(@PathVariable long typeNo,@PathVariable long boardNo, Model model) {
        log.info("/board/{typeNo}/{boardNo}");
        model.addAttribute("typeNo", typeNo);
        model.addAttribute("boardNo", boardNo);

        return "boardcontent";
    }

    @GetMapping("/board/{typeNo}/{boardNo}/update")
    public String boadrUpdate(@PathVariable long typeNo, @PathVariable long boardNo, Model model){
        log.info("update form");
        model.addAttribute("typeNo", typeNo);
        model.addAttribute("boardNo",boardNo);
        return "boardupdate";
    }
}
