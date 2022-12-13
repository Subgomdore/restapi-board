package com.project.restapiboard.controller.board;

import com.project.restapiboard.dto.request.RequestBoardDto;
import com.project.restapiboard.dto.response.ResBoardeListDto;
import com.project.restapiboard.dto.response.ResponseBoardDto;
import com.project.restapiboard.entity.Board;
import com.project.restapiboard.service.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        List<ResBoardeListDto> res = boardService.getBoardList(typeNo);
        return res;
    }

    /*게시글 조회수 상승*/
    @PutMapping("/{typeNo}/{boardNo}/count")
    public void contentCount(@PathVariable long typeNo, @PathVariable long boardNo){
        boardService.countContent(boardNo);
    }


    /*게시판의 상세내용 불러오기*/
    @PostMapping("/{typeNo}/{boardNo}")
    public ResponseBoardDto getBoardContent(@PathVariable long typeNo, @PathVariable long boardNo){
        return boardService.getBoardContent(boardNo);
    }

    /*게시판에 글작성하기*/
    @PostMapping("/{typeNo}/write-add")
    public void addContent(@RequestBody RequestBoardDto boardDto, @PathVariable long typeNo) {
        log.error("{}", boardDto.getBoardContent());
        boardService.addContent(boardDto);
    }

    /*게시판글 수정하기*/
    /*원하는 컬럼데이터만 받아서 변경하고싶은데... 방법을 모르겠다*/
    @PutMapping("/{typeNo}/{boardNo}/update")
    public void updateContent(RequestBoardDto boardDto) {
        log.info(boardDto.getBoardContent());
        boardService.updateContent(boardDto);
    }

    /*게시글 삭제하기*/
    @DeleteMapping("/{typeNo}/{boardNo}/delete")
    public void deleteContent(@RequestBody RequestBoardDto boardDto, @PathVariable long typeNo, @PathVariable long boardNo){
        boardService.deleteContent(boardDto);
    }
}
