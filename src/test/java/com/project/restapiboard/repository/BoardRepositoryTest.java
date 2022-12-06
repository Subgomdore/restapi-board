package com.project.restapiboard.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
@Rollback(value = false)
class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;


    @Test
    public void testBoard(){


    }

}