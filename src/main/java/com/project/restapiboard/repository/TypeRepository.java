package com.project.restapiboard.repository;

import com.project.restapiboard.entity.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface TypeRepository extends JpaRepository<Type, Long> {

}
