package com.project.restapiboard.repository;

import com.project.restapiboard.entity.Board;
import com.project.restapiboard.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    Page<Board> findByType(Type type , Pageable pageable); //? 이게 왜되는거지? 객체로 조회가능하네?

    /*조회수 증가가*/
   @Transactional /** @Transactional이 포함하고 있는 작업 중에 하나라도 실패할 경우 전체 작업을 취소*/
    @Modifying
    @Query("update Board b set b.boardCount = b.boardCount + 1 where b.boardNo = :boardNo")
    void updateCount(long boardNo);

}
