package com.project.restapiboard.service;

import com.project.restapiboard.repository.BoardTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardTypeService {

    @Autowired
    private BoardTypeRepository boardTypeRepository;

    public boolean idCheck(Long boardId){
        return boardTypeRepository.existsById(boardId);
    }
}
