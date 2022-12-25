package com.project.restapiboard.controller.page;

import com.project.restapiboard.dto.request.ReqPagingDto;
import com.project.restapiboard.dto.response.ResPagingDto;
import com.project.restapiboard.repository.UserRepository;
import com.project.restapiboard.service.PageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@Slf4j
public class PageController {

    @Autowired
    PageService pageService;

    /*디폴트 맵핑경로*/
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
    public String boardTypeList() {
        log.info("/board");
        return "boardtypelist";
    }

    /*특정게시판안의 리스트 불러오기*/
    @RequestMapping("/board/{typeNo}/page/{page_number}")
    public String boardList(@PathVariable long typeNo, @PathVariable int page_number,
                            ReqPagingDto reqPagingDto, Model model) {

        /*Paging 과 관련된 객체들을 ViewPage로 전달*/
        /*해당 페이지에서는 전달받은 Object로 List 재호출*/
        log.info("/board/{typeNo}");

        int page = page_number-1;
        int pageSize = 3;
        int offsetSize = 5;

        reqPagingDto.setPage(page);
        reqPagingDto.setPageSize(pageSize);

        ResPagingDto paging = pageService.getPaging(reqPagingDto);

        int startPage = (((int) ((double) (page+1) / 10 + 0.9)) - 1) * 10 + 1;
        int maxPage = (int) ((double) paging.getTotalElements() / pageSize + 0.95); // 0.95를 더해서 올림
        int endPage = maxPage;
        if(endPage > startPage + offsetSize-1){
            endPage = startPage + offsetSize-1;
        }


        model.addAttribute("totalPages", paging.getTotalPages());
        model.addAttribute("totalElements", paging.getTotalElements());
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("typeNo", typeNo);
        model.addAttribute("page", page);
//        return "redirect:/board/{typeNo}";
        log.info(Long.toString(page));
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
    @GetMapping("/board/{typeNo}/content/{boardNo}")
    public String boardContent(@PathVariable long typeNo, @PathVariable long boardNo, Model model) {
        log.info("/board/{typeNo}/{boardNo}");
        model.addAttribute("typeNo", typeNo);
        model.addAttribute("boardNo", boardNo);

        return "boardcontent";
    }

    @GetMapping("/board/{typeNo}/{boardNo}/update")
    public String boadrUpdate(@PathVariable long typeNo, @PathVariable long boardNo, Model model) {
        log.info("update form");
        model.addAttribute("typeNo", typeNo);
        model.addAttribute("boardNo", boardNo);
        return "boardupdate";
    }
}
