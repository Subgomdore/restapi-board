package com.project.restapiboard.controller.board;

import com.project.restapiboard.dto.request.RequestBoardDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 황인성

@RestController
@RequestMapping
@Slf4j
public class Board1002 {

    @GetMapping("/1002")
    public void test(@RequestBody RequestBoardDto requestBoardDto){
        log.info("========== /1002/list ==========");
        System.out.println("/1002/도착");
    }

//
//    @PostMapping("/1002/add")
//    public void addBoard(@RequestBody BoardTypeDTO boardTypeDTO) {
//        boardTypeDTO = boardTypeService.boardAdd(boardTypeDTO);
//        log.info(boardTypeDTO.getBoard_name());
//    }

}
