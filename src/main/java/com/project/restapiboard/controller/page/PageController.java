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

    /*특정게시판안의 리스트 불러오기*/
    @RequestMapping("/board/{typeNo}/page/{page_number}")
    public String boardList(@PathVariable long typeNo, @PathVariable int page_number,
                            ReqPagingDto reqPagingDto, Model model) {

        /*Paging 과 관련된 객체들을 ViewPage로 전달*/
        /*해당 페이지에서는 전달받은 Object로 List 재호출*/
        log.info("/*특정게시판안의 리스트 불러오기*/");

        int page = page_number - 1;

        log.info(Long.toString(page));
        log.info(Long.toString(reqPagingDto.getPageSize()));

        int pageSize = 10; // 한페이지에 몇개씩
        if(reqPagingDto.getPageSize() != 0) {
            pageSize = reqPagingDto.getPageSize();
        }
        int offsetSize = 5; // 하단 페이징 그룹 몇개까지 표시할지


        reqPagingDto.setPage(page);
        reqPagingDto.setPageSize(pageSize);

        ResPagingDto paging = pageService.getPaging(reqPagingDto);

        int startPage = (((int) ((double) (page + 1) / 10 + 0.9)) - 1) * 10 + 1;
        int maxPage = (int) ((double) paging.getTotalElements() / pageSize + 0.95); // 0.95를 더해서 올림
        int endPage = maxPage;
        if (endPage > startPage + offsetSize - 1) {
            endPage = startPage + offsetSize - 1;
        }

        // 객체로 넘길예정. Wrapper에 대한 이해때문에 아직 jstl 바로 호출하기위한 편의성으로 임시로 달아둠..
        model.addAttribute("paging",paging);
        model.addAttribute("totalPages", paging.getTotalPages());
        model.addAttribute("totalElements", paging.getTotalElements());
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);
        model.addAttribute("typeNo", typeNo);
        model.addAttribute("page", page);
        log.info(Long.toString(page));
        return "boardlist";
    }

    /*특정게시판의 글쓰기 페이지이동*/
    @RequestMapping("/board/{typeNo}/boardwrite")
    public String boardWrite(@PathVariable long typeNo, Model model) {
        model.addAttribute("typeNo", typeNo);
        return "boardwrite";
    }

    /*특정게시판의 상세내용보기 페이지이동*/
    @GetMapping("/board/{typeNo}/content/{boardNo}")
    public String boardContent(@PathVariable long typeNo, @PathVariable long boardNo, Model model) {
        model.addAttribute("typeNo", typeNo);
        model.addAttribute("boardNo", boardNo);

        return "boardcontent";
    }

    @GetMapping("/board/{typeNo}/{boardNo}/update")
    public String boadrUpdate(@PathVariable long typeNo, @PathVariable long boardNo, Model model) {
        model.addAttribute("typeNo", typeNo);
        model.addAttribute("boardNo", boardNo);
        return "boardupdate";
    }
}
