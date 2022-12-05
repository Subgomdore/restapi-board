package com.project.restapiboard.service;


import com.project.restapiboard.dto.request.RequestTypeDto;
import com.project.restapiboard.dto.response.ResponseTypeDto;
import com.project.restapiboard.entity.Type;
import com.project.restapiboard.repository.TypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class TypeService {

    @Autowired
    TypeRepository typeRepository;

    public void boardTypeAdd(RequestTypeDto requestTypeDto) {
        Type type = requestTypeDto.toEntity();
        typeRepository.save(type);
    }

    public List<ResponseTypeDto> boardTypeList() {
        List<Type> typeList = typeRepository.findAll(); // Entity list 찾고
        List<ResponseTypeDto> responseTypeDtoList = new ArrayList<>(); // DTO list 만들고

        for(Type type : typeList) {
            ResponseTypeDto responseTypeDto = new ResponseTypeDto(type); // response 객체를 생성하면서, Entity를 매개변수로 넣음 : Entity -> Dto 변환
            responseTypeDtoList.add(responseTypeDto);
        }
        return responseTypeDtoList;
    }


//    public List<BoardTypeDTO> BoardTypeListfindAll() {
//        return boardTypeRepository.findAll();
//    }
//
//    public BoardTypeDTO boardAdd(BoardTypeDTO boardType) {
//        return boardTypeRepository.save(boardType);
//    }

}
