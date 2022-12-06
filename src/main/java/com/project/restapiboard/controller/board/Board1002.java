package com.project.restapiboard.controller.board;

import com.project.restapiboard.dto.request.Req;
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

    @PostMapping("/{typeNo}/list")
    public List<ResBoardeListDto> getBoardList(@PathVariable long typeNo) {
        log.info("========== /" + typeNo + "/list ==========");
        List<ResBoardeListDto> res = boardService.getBoardList(typeNo);
        return res;
    }

    @GetMapping("/{typeNo}/{boardNo}/cnt")
    public ResponseBoardDto getBoardContent(@PathVariable long typeNo, long boardNo){
        log.info("========== /"+typeNo+"/"+boardNo+" ==========");
        return boardService.getBoardContent(boardNo);
    }


    @PostMapping("/{typeNo}/write-add")
    public void addContent(@RequestBody Req req, @PathVariable long typeNo) {
        log.info("==========  /{boardtype_no}/write-add ========== ");
        log.info("{}", req);
        boardService.addContent(req);
    }


}
