package com.project.restapiboard.controller.board;

import com.project.restapiboard.dto.request.RequestBoardTypeDto;
import com.project.restapiboard.dto.response.ResponseBoardTypeDto;
import com.project.restapiboard.service.BoardTypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@Slf4j
public class BoardTypeController {

    @Autowired
    BoardTypeService boardTypeService;

    /*게시판타입 추가*/
    @PostMapping("/boardtype-add")
    public void boardTypeAdd(@RequestBody RequestBoardTypeDto requestBoardTypeDto) {
        log.info("========== /boardtype-add ==========");
        boardTypeService.boardTypeAdd(requestBoardTypeDto);
    }

    @GetMapping("/list")
    public List<ResponseBoardTypeDto> BoardTypeList() {
        log.info("========== /board/list호출 ==========");

        return boardTypeService.boardTypeList();
    }


}
