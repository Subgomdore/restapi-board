package com.project.restapiboard.controller.board;

import com.project.restapiboard.entity.BoardType;
import com.project.restapiboard.service.BoardService;
import com.project.restapiboard.service.BoardTypeService;
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
    private BoardService boardService;

    @Autowired
    private BoardTypeService boardTypeService;

    @GetMapping("/list")
    public List<BoardType> BoardTypeList() {
        log.info("/board/list호출");
        return boardTypeService.BoardTypeListfindAll();
    }

    @PostMapping("/1002/add")
    public void addBoard(@RequestBody BoardType boardType) {
        boardType = boardTypeService.addBoard(boardType);
      log.info(boardType.getBoardtype_name());
    }

}
