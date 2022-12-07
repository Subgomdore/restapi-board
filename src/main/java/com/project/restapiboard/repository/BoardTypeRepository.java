package com.project.restapiboard.repository;

import com.project.restapiboard.entity.BoardType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardTypeRepository extends JpaRepository<BoardType, Long> {

}
