package com.project.restapiboard.service;

import com.project.restapiboard.dto.response.ResponseBoardDto;
import com.project.restapiboard.entity.Board;
import com.project.restapiboard.repository.BoardRepository;
import com.project.restapiboard.repository.TypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    TypeRepository typeRepository;

    // Entity에 는 boardtype_no가 없다. ( DB에는 boardtype_no가 있다)
    // No property 'boardList' found for type 'Board'
    //    즉, findBy + (fk필드_첫문자는대문자) + "_" + "fk도메인의 ID 필드" 로 생성하면 된다 !
    public List<ResponseBoardDto> getBoardList(long typeNo) {
        log.info("========== service: getBoardList ==========");
        List<Board>  boards = typeRepository.findByTypeNo_TypeNo(typeNo);

        List<ResponseBoardDto> responseBoardDtoList = new ArrayList<>();
        for(Board board : boards){
            ResponseBoardDto responseBoardDto = new ResponseBoardDto(board);
            responseBoardDtoList.add(responseBoardDto);
        }

        return responseBoardDtoList;
    }

//    public void boardAdd(RequestBoardDto requestBoardDto) {
//        Board board = requestBoardDto.toEntity();
//        boardRepository.save(board);
//    }
}
