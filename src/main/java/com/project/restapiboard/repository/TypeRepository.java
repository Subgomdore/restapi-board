package com.project.restapiboard.repository;

import com.project.restapiboard.entity.Board;
import com.project.restapiboard.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface TypeRepository extends JpaRepository<Type, Long> {
    List<Board> findByTypeNo_TypeNo(long typeNo);

//    List<Board> findByType_TypeNo(long typeNo);

//    List<Board> findByType_typeNo(long typeNo);
}
