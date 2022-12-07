package com.project.restapiboard.repository;


import com.project.restapiboard.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

// @Repository 어노테이션이 없어도 IoC(Inversion of Control) 작동 가능 - JpaRepository 를 상속했기 때문에 가능
public interface UserRepository extends JpaRepository<User, String> {

    // findBy 규칙 -> User_id 문법
    // select * from user where user_id = 1?
    User findByUserId(String username); // JPA

    User findByNickName(String nickname);



}
