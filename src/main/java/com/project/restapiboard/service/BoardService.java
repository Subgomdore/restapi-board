package com.project.restapiboard.service;

import com.project.restapiboard.dto.request.Req;
import com.project.restapiboard.dto.request.RequestTypeDto;
import com.project.restapiboard.dto.response.ResBoardeListDto;
import com.project.restapiboard.dto.response.ResponseBoardDto;
import com.project.restapiboard.dto.response.ResponseTypeDto;
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

    // Entity에 는 boardtype_no가 없다. ( DB에는 boardtype_no가 있다)
    // No property 'boardList' found for type 'Board'
    public List<ResBoardeListDto> getBoardList(long typeNo) {
        log.info("========== service: getBoardList ==========");
        List<Board> boardList = boardRepository.findByType_TypeNo(typeNo);

        for (int i = 0; i < boardList.size(); i++) {
            log.info("게시물수 :"+ Long.toString(boardList.size()));
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

    /*게시글 상세내용 확인보기. view페이지 구현안됬음*/
    public ResponseBoardDto getBoardContent(long boardNo) {
        Optional<Board> board = boardRepository.findById(boardNo);
        if (!board.isPresent()) {
            return null;
        }
        ResponseBoardDto boardDto = new ResponseBoardDto(board.get());
        return boardDto;
    }

    public void addContent(Req req) {
        Optional<Type> type = typeRepository.findById(req.getTypeNo()); // Type Entity
        Optional<User> user = userRepository.findById(req.getUserId()); // User Etnity

        req.setUser(user.get());
        req.setType(type.get());
        Board board = req.toEntity();
        log.info(Long.toString(board.getType().getTypeNo()));
        log.info(board.getUser().getUserId());
        boardRepository.save(board);


//        User user = req.SetUserId(req.getUserId()); // 형식이 맞지않음... 객체를 넣어야되는데 String값임

        /** req에 있는 인자값 UserId, TypeNo를 객체로 가공해줘야하는데.. 방법이.... */


//        User user = req.toEntity();
//        log.info(user.getUserId());
//        boardRepository.save(board);
    }

}
