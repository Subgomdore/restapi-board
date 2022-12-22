package com.project.restapiboard.repository;

import com.project.restapiboard.entity.Board;
import com.project.restapiboard.entity.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PageRepository extends JpaRepository<Board, Long> {
    Page<Board> findByType(Type type, PageRequest pageRequest);
}
