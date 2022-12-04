package com.project.restapiboard.service;


import com.project.restapiboard.dto.request.RequestBoardTypeDto;
import com.project.restapiboard.dto.response.ResponseBoardTypeDto;
import com.project.restapiboard.entity.BoardType;
import com.project.restapiboard.repository.BoardTypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class BoardTypeService {

    @Autowired
    BoardTypeRepository boardTypeRepository;

    public void boardTypeAdd(RequestBoardTypeDto requestBoardTypeDto) {
        BoardType boardType = requestBoardTypeDto.toEntity();
        boardTypeRepository.save(boardType);
    }

    public List<ResponseBoardTypeDto> boardTypeList() {
        List<BoardType> boardTypeList = boardTypeRepository.findAll(); // Entity list 찾고
        List<ResponseBoardTypeDto> responseBoardTypeDtoList = new ArrayList<>(); // DTO list 만들고

        for(BoardType boardType : boardTypeList) {
            ResponseBoardTypeDto responseBoardTypeDto = new ResponseBoardTypeDto(boardType); // response 객체를 생성하면서, Entity를 매개변수로 넣음 : Entity -> Dto 변환
            responseBoardTypeDtoList.add(responseBoardTypeDto);
        }
        return responseBoardTypeDtoList;
    }


//    public List<BoardTypeDTO> BoardTypeListfindAll() {
//        return boardTypeRepository.findAll();
//    }
//
//    public BoardTypeDTO boardAdd(BoardTypeDTO boardType) {
//        return boardTypeRepository.save(boardType);
//    }

}
