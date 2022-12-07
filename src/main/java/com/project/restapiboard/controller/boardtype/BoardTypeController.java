package com.project.restapiboard.controller.boardtype;

import com.project.restapiboard.service.BoardTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/boardtype")
public class BoardTypeController {

    @Autowired
    private BoardTypeService boardTypeService;

    @GetMapping("/IdCheck")
    public boolean idCheck(@RequestParam("boardId") Long boardId){
        boolean cnt = boardTypeService.idCheck(boardId);
        return cnt;
    }

}
