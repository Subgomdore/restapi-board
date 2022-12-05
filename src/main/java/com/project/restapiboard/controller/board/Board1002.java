package com.project.restapiboard.controller.board;

import com.project.restapiboard.dto.request.RequestBoardDto;
import com.project.restapiboard.dto.response.ResponseBoardDto;
import com.project.restapiboard.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

// 황인성

@RestController
@RequestMapping("/board")
@Slf4j
public class Board1002 {

    @Autowired
    BoardService boardService;

    @PostMapping("/{typeNo}/list")
    public List<ResponseBoardDto> getBoardList (@RequestBody @PathVariable long typeNo) {
        log.info("========== /1002/list ==========");
        System.out.println(typeNo);
        List<ResponseBoardDto> boardList = boardService.getBoardList(typeNo);
        log.info("===================================== 리턴되는거니????????????????????????????");
        return boardList;
    }


//    @PostMapping("/{boardtype_no}/write-add")
//    public void boardAdd(@RequestBody RequestBoardDto requestBoardDto) {
//        boardService.boardAdd(requestBoardDto);
//    }


}
