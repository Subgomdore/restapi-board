package com.project.restapiboard.controller.board;

import com.project.restapiboard.dto.request.ReqBoardDto;
import com.project.restapiboard.dto.request.ReqPagingDto;
import com.project.restapiboard.dto.request.ReqTypeDto;
import com.project.restapiboard.dto.response.ResBoardWrapperDto;
import com.project.restapiboard.dto.response.ResPagingDto;
import com.project.restapiboard.dto.response.ResBoardDto;
import com.project.restapiboard.entity.Type;
import com.project.restapiboard.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

// 황인성

@RestController
@RequestMapping("/board")
@Slf4j
public class BoardController {

    @Autowired
    BoardService boardService;

    /*특정게시판안의 리스트 불러오기*/
    @PostMapping("/{typeNo}/list/{page}")
    public ResBoardWrapperDto getBoardList(@PathVariable long typeNo, @PathVariable int page,
                                           ReqPagingDto pagingDto) {
        ResBoardWrapperDto res = new ResBoardWrapperDto();

        res.setList(boardService.getBoardList(pagingDto, page));
//        res.setPaging();
        return res;
    }

    /*게시판의 상세내용 불러오기*/
    @PostMapping("/{typeNo}/{boardNo}")
    public ResBoardDto getBoardContent(@PathVariable long typeNo, @PathVariable long boardNo) {
        return boardService.getBoardContent(boardNo);
    }

    /*게시판에 글작성하기*/
    @PostMapping("/{typeNo}/write-add")
    public void addContent(@RequestBody ReqBoardDto boardDto, @PathVariable long typeNo) {
        boardService.addContent(boardDto);
    }

    /*게시글 조회수 상승*/
    @PutMapping("/{typeNo}/{boardNo}/count")
    public void contentCount(@PathVariable long typeNo, @PathVariable long boardNo) {
        boardService.updateCount(boardNo);
    }

    /*게시글 수정하기*/
    @PostMapping("/{typeNo}/{boardNo}/update")
    public void updateContent(@PathVariable long typeNo, @PathVariable long boardNo,@RequestBody ReqBoardDto boardDto){
        log.info(boardDto.getBoardContent());
        boardService.updateContent(boardDto, boardNo);
    }

}
