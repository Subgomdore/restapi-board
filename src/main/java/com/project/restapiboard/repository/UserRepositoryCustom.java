package com.project.restapiboard.repository;

import com.project.restapiboard.entity.User;
import com.project.restapiboard.request.PagingClass;

import java.util.List;

public interface UserRepositoryCustom {

    List<User> getAllUser(PagingClass pagingClass);
}
