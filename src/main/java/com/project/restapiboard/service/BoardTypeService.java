package com.project.restapiboard.service;

import com.project.restapiboard.entity.BoardType;
import com.project.restapiboard.repository.BoardTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardTypeService {

    @Autowired
    BoardTypeRepository boardTypeRepository;

    public List<BoardType> BoardTypeListfindAll() {
        return boardTypeRepository.findAll();
    }

    public BoardType addBoard(BoardType boardType) {
        return boardTypeRepository.save(boardType);
    }
}
