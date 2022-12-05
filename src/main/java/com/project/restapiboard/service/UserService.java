package com.project.restapiboard.service;

import com.project.restapiboard.entity.User;
import com.project.restapiboard.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> getMemberList(){
        return userRepository.findAll();
    }

    public User save(User user) {
        user.setRole("ROLE_USER"); // 기본 권한 등급 유저
        // 그냥 비밀번호는 암호화가 안되어 있어 시큐리티로 로그인을 할 수가 없음.
        String rawPassword = user.getUserPass();   // password 를 받아서
        String encPassword = bCryptPasswordEncoder.encode(rawPassword); // password 변환
        user.setUserPass(encPassword);   // DB에 저장할 객체에 변환한 비밀번호 갱
        return  userRepository.save(user);
    }

    public boolean idCheck(String user_id){
        return userRepository.existsById(user_id);
    }

}
