package com.project.restapiboard.repository;

import com.project.restapiboard.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findByType_TypeNo(long typeNo);

    @Transactional
    // @Transactional이 붙은 메서드는 메서드가 포함하고 있는 작업 중에 하나라도 실패할 경우 전체 작업을 취소한다.
    @Modifying
    @Query("update Board b set b.boardCount = b.boardCount + 1 where b.boardNo = :boardNo")
    void updateCount(long boardNo);
}
