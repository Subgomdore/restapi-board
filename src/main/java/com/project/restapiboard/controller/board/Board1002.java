package com.project.restapiboard.controller.board;

import com.project.restapiboard.dto.request.RequestBoardDto;
import com.project.restapiboard.dto.response.ResBoardeListDto;
import com.project.restapiboard.dto.response.ResponseBoardDto;
import com.project.restapiboard.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 황인성

@RestController
@RequestMapping("/board")
@Slf4j
public class Board1002 {

    @Autowired
    BoardService boardService;

    /*특정게시판안의 리스트 불러오기*/
    @PostMapping("/{typeNo}/list")
    public List<ResBoardeListDto> getBoardList(@PathVariable long typeNo) {
        log.info("========== /" + typeNo + "/list ==========");
        List<ResBoardeListDto> res = boardService.getBoardList(typeNo);
        return res;
    }

    /*게시글 조회수 상승*/
    @PostMapping("/{typeNo}/{boardNo}/count")
    public void contentCount(@PathVariable long typeNo, @PathVariable long boardNo){
        log.error("==========================================================count =====================================");
        boardService.contentCount(boardNo);
    }


    /*게시판의 상세내용 불러오기*/
    @PostMapping("/{typeNo}/{boardNo}")
    public ResponseBoardDto getBoardContent(@PathVariable long typeNo, @PathVariable long boardNo){
        log.info("상세컨텐츠");
        return boardService.getBoardContent(boardNo);
    }

    /*게시판에 글작성하기*/
    @PostMapping("/{typeNo}/write-add")
    public void addContent(@RequestBody RequestBoardDto boardDto, @PathVariable long typeNo) {
        log.info("==========  /{boardtype_no}/write-add ========== ");
        log.error(boardDto.getUserId());
        log.error(boardDto.getBoardSubject());
        log.error("{}", boardDto.getBoardContent());
        boardService.addContent(boardDto);
    }

}
