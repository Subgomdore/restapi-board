package com.project.restapiboard.controller.admin;

import com.project.restapiboard.request.PagingClass;
import com.project.restapiboard.respoonse.UserResponse;
import com.project.restapiboard.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/alluser")
    public List<UserResponse> getAllUser(@ModelAttribute PagingClass pagingClass){
        return userService.getAllUser(pagingClass);
    }

}
