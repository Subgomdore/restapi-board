package com.project.restapiboard.repository;


import com.project.restapiboard.entity.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    //@EntityGraph = 쿼리가 수행 될때, lazy 조회가 아니고, Eager 조회로 authorities 정보를 같이 가져옴
    @EntityGraph(attributePaths = "authorities")
    Optional<User> findOneWithAuthoritiesByUser_id(String user_id);
}
