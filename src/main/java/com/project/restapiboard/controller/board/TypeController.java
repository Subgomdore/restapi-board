package com.project.restapiboard.controller.board;

import com.project.restapiboard.dto.request.RequestTypeDto;
import com.project.restapiboard.dto.response.ResponseTypeDto;
import com.project.restapiboard.service.TypeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
@Slf4j
public class TypeController {

    @Autowired
    TypeService typeService;

    /*게시판타입 추가*/
    @PostMapping("/boardtype-add")
    public void boardTypeAdd(@RequestBody RequestTypeDto requestTypeDto) {
        log.info("========== /boardtype-add ==========");
        typeService.boardTypeAdd(requestTypeDto);
    }

    /*게시판리스트*/
    @GetMapping("/list")
    public List<ResponseTypeDto> BoardTypeList() {
        log.info("========== /board/list호출 ==========");

        return typeService.boardTypeList();
    }


}
