package com.project.restapiboard.repository;


import com.project.restapiboard.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    public List<User> findAll();			// 전체 목록 검색

    public User findByNo(int user_no);			// 상세 정보

}
