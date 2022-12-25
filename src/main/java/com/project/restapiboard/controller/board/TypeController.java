package com.project.restapiboard.controller.board;

import com.project.restapiboard.dto.request.ReqTypeDto;
import com.project.restapiboard.dto.response.ResTypeDto;
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
    public void boardTypeAdd(@RequestBody ReqTypeDto reqTypeDto) {
        typeService.boardTypeAdd(reqTypeDto);
    }

    /*게시판리스트*/
    @GetMapping("/list")
    public List<ResTypeDto> BoardTypeList() {
        return typeService.boardTypeList();
    }


}
