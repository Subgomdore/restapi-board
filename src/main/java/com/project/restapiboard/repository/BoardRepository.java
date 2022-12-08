package com.project.restapiboard.repository;

import com.project.restapiboard.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {

    List<Board> findByType_TypeNo(long typeNo);

    @Modifying
    @Query("update Board b set b.boardCount = b.boardContent + 1 where b.boardNo = :boardNo")
    void updateCount(long boardNo);
}
