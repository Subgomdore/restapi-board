package com.project.restapiboard.repository;

import com.project.restapiboard.entity.QUser;
import com.project.restapiboard.entity.User;
import com.project.restapiboard.request.PagingClass;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepositoryCustom{

    private final JPAQueryFactory jpaQueryFactory;

    @Override
    public List<User> getAllUser(PagingClass pagingClass) {
        return jpaQueryFactory.selectFrom(QUser.user)
                .limit(pagingClass.getSize())
                .offset(pagingClass.getOffset())
                .orderBy(QUser.user.userId.desc())
                .fetch();
    }
}
