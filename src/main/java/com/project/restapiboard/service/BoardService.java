package com.project.restapiboard.service;

import com.project.restapiboard.dto.request.ReqBoardDto;
import com.project.restapiboard.dto.request.ReqPagingDto;
import com.project.restapiboard.dto.request.ReqTypeDto;
import com.project.restapiboard.dto.response.ResPagingDto;
import com.project.restapiboard.dto.response.ResBoardDto;
import com.project.restapiboard.entity.Board;
import com.project.restapiboard.entity.Type;
import com.project.restapiboard.entity.User;
import com.project.restapiboard.repository.BoardRepository;
import com.project.restapiboard.repository.TypeRepository;
import com.project.restapiboard.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    /*게시물 리스트*/
    public List<ResBoardDto> getBoardList(ReqPagingDto reqPagingDto, int page) {
        /** typeNo 단일 매개변수로 받았을경우 조회 */
        /** 페이징 작업없이 전체 리스트를 모두 불러오는 기능이고, FK를 활용한 단일조회 문법이다 */

        /** CheckNumber = '1'
         * List<Board> boardList = boardRepository.findByType_TypeNo(type); */

        /** JPA는 객체로 조회가 가능하다. 이 기능은 절대 잊지말고 기억하기 */
        PageRequest pageRequest = PageRequest.of(page,3,Sort.by(Sort.Direction.DESC,"boardNo"));
        Type type = Type.builder().typeNo(reqPagingDto.getTypeNo()).build();
        Page<Board> boardPage = boardRepository.findByType(type, pageRequest);
        List<Board> boardList = boardPage.getContent();

        List<ResBoardDto> boardDtoList = new ArrayList<>();

        for (int i = 0; i < boardList.size(); i++) {
            ResBoardDto boardDto = new ResBoardDto(boardList.get(i));
            boardDtoList.add(boardDto);
        }
        return boardDtoList;
    }


    /*게시글 상세내용 확인보기*/
    public ResBoardDto getBoardContent(long boardNo) {
        Optional<Board> board = boardRepository.findById(boardNo);
        if (!board.isPresent()) {
            return null;
        }
        ResBoardDto boardDto = new ResBoardDto(board.get());
        return boardDto;
    }

    /*게시글 작성*/
    @Transactional
    public void addContent(ReqBoardDto boardDto) {

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

    /*게시글 업데이트. 아직 미완성*/
    public void updateContent(ReqBoardDto boardDto, long boardNo) {
        // boardNo 값 DTO Builder 처리해야함
        Board board = boardDto.toEntity();
        boardRepository.save(board);
    }

    /*게시글 삭제*/
    public void deleteContent(ReqBoardDto boardDto) {
        Board board = boardDto.toEntity();
        boardRepository.delete(board);
    }


}
