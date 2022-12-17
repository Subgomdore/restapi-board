package com.project.restapiboard.service;

import com.project.restapiboard.dto.request.RequestBoardDto;
import com.project.restapiboard.dto.response.ResBoardeListDto;
import com.project.restapiboard.dto.response.ResPagingDto;
import com.project.restapiboard.dto.response.ResponseBoardDto;
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

    /*게시물 페이징*/
    public ResPagingDto getPagingValue(Type type) {

        PageRequest pageRequest = PageRequest.of(0,3,Sort.by(Sort.Direction.DESC,"boardNo"));
        Page<Board> boardPage = boardRepository.findByType(type, pageRequest);
        ResPagingDto resPagingDto = new ResPagingDto();
        resPagingDto.setTotalPages(boardPage.getTotalPages());
        resPagingDto.setTotalElements(boardPage.getTotalElements());
        return resPagingDto;
    }

    /*게시물 리스트*/
    public List<ResBoardeListDto> getBoardList(Type type, int page) {
        /** typeNo 단일 매개변수로 받았을경우 조회 */
        /** 페이징 작업없이 전체 리스트를 모두 불러오는 기능이고, FK를 활용한 단일조회 문법이다 */

        /** CheckNumber = '1'
         * List<Board> boardList = boardRepository.findByType_TypeNo(type); */

        /** JPA는 객체로 조회가 가능하다. 이 기능은 절대 잊지말고 기억하기 */
        PageRequest pageRequest = PageRequest.of(page,3,Sort.by(Sort.Direction.DESC,"boardNo"));
        Page<Board> boardPage = boardRepository.findByType(type, pageRequest);
        List<Board> boardList = boardPage.getContent();

        int totalPages = boardPage.getTotalPages();
        System.out.println("totalPages = " + totalPages);
        long totalElements = boardPage.getTotalElements();
        System.out.println("totalElements = " + totalElements);

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

    /*게시글 업데이트. 아직 미완성*/
    public void updateContent(RequestBoardDto boardDto, long boardNo) {
        // boardNo 값 DTO Builder 처리해야함
        Board board = boardDto.toEntity();
        boardRepository.save(board);
    }

    /*게시글 삭제*/
    public void deleteContent(RequestBoardDto boardDto) {
        Board board = boardDto.toEntity();
        boardRepository.delete(board);
    }


}
