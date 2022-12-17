package com.project.restapiboard.service;

import com.project.restapiboard.dto.request.RequestBoardDto;
import com.project.restapiboard.dto.response.ResBoardeListDto;
import com.project.restapiboard.dto.response.ResponseBoardDto;
import com.project.restapiboard.entity.Board;
import com.project.restapiboard.entity.Type;
import com.project.restapiboard.entity.User;
import com.project.restapiboard.repository.BoardRepository;
import com.project.restapiboard.repository.TypeRepository;
import com.project.restapiboard.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class BoardService {

    @Autowired
    BoardRepository boardRepository;

    @Autowired
    TypeRepository typeRepository;

    @Autowired
    UserRepository userRepository;

    public List<ResBoardeListDto> getBoardList(long typeNo) {
        log.info("========== service: getBoardList ==========");
        List<Board> boardList = boardRepository.findByType_TypeNo(typeNo);

        for (int i = 0; i < boardList.size(); i++) {
            log.info("boardSubject: {}", boardList.get(i).getBoardSubject());
        }

        // id랑 typeno를 가진 dto 리스트 생성
        List<ResBoardeListDto> resBoardeListDtos = new ArrayList<>();
        for (int i = 0; i < boardList.size(); i++) {
            ResBoardeListDto resBoardeListDto = new ResBoardeListDto(boardList.get(i));
            resBoardeListDtos.add(resBoardeListDto);
        }
        return resBoardeListDtos;
    }

    /*게시글 상세내용 확인보기*/
    public ResponseBoardDto getBoardContent(long boardNo) {
        Optional<Board> board = boardRepository.findById(boardNo);
        if (!board.isPresent()) {
            return null;
        }
        ResponseBoardDto boardDto = new ResponseBoardDto(board.get());
        return boardDto;
    }

    /*게시글 작성*/
    public void addContent(RequestBoardDto boardDto) {

        Optional<Type> type = typeRepository.findById(boardDto.getTypeNo()); // Type Entity
        Optional<User> user = userRepository.findById(boardDto.getUserId()); // User Etnity

        boardDto.setUser(user.get());
        boardDto.setType(type.get());

        Board board = boardDto.toEntity();
        boardRepository.save(board);
    }

    /*조회수 증가*/
    public void updateCount(long boardNo) {
        boardRepository.updateCount(boardNo);
    }


    public void updateContent(RequestBoardDto boardDto, long boardNo) {
        // boardNo 값 DTO Builder 처리해야함
        Board board = boardDto.toEntity();
        boardRepository.save(board);

    }

}
