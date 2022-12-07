package com.project.restapiboard.service;

import com.project.restapiboard.dto.request.Req;
import com.project.restapiboard.dto.response.ResBoardeListDto;
import com.project.restapiboard.dto.response.ResponseBoardDto;
import com.project.restapiboard.entity.Board;
import com.project.restapiboard.entity.User;
import com.project.restapiboard.repository.BoardRepository;
import com.project.restapiboard.repository.TypeRepository;
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

    // Entity에 는 boardtype_no가 없다. ( DB에는 boardtype_no가 있다)
    // No property 'boardList' found for type 'Board'
    public List<ResBoardeListDto> getBoardList(long typeNo) {
        log.info("========== service: getBoardList ==========");
        List<Board> boardList = boardRepository.findByType_TypeNo(typeNo);

        for (int i = 0; i < boardList.size(); i++) {
            log.info(Long.toString(boardList.size()));
            log.info("{}", boardList);
        }

        // id랑 typeno를 가진 dto 리스트 생성
        List<ResBoardeListDto> resBoardeListDtos = new ArrayList<>();
        for (int i = 0; i < boardList.size(); i++) {
            ResBoardeListDto resBoardeListDto = new ResBoardeListDto(boardList.get(i));
            resBoardeListDtos.add(resBoardeListDto);
        }
        return resBoardeListDtos;
    }

    public ResponseBoardDto getBoardContent(long boardNo) {
        Optional<Board> board = boardRepository.findById(boardNo);
        if (!board.isPresent()) {
            return null;
        }
        ResponseBoardDto boardDto = new ResponseBoardDto(board.get());
        return boardDto;
    }

    public void addContent(Req req) {
        Board board = req.toEntity();               /** 이렇게되면 board Entity에는 User,Type객체가 존재하지않음 */
        User user = req.SetUserId(req.getUserId()); // 형식이 맞지않음... 객체를 넣어야되는데 String값임

        /** req에 있는 인자값 UserId, TypeNo를 객체로 가공해줘야하는데.. 방법이.... */


//        User user = req.toEntity();
        log.info(user.getUserId());
//        boardRepository.save(board);
    }

}
