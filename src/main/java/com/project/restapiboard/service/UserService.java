package com.project.restapiboard.service;

import com.project.restapiboard.entity.User;
import com.project.restapiboard.repository.UserRepository;
import com.project.restapiboard.repository.UserRepositoryImpl;
import com.project.restapiboard.request.PagingClass;
import com.project.restapiboard.respoonse.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

//    private final UserRepository userRepository;

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

    public User nickCheck(String nickName) {
        return userRepository.findByNickName(nickName);
    }

    public List<UserResponse> getAllUser(PagingClass pagingClass){
        return userRepository.getAllUser(pagingClass).stream()
                .map(UserResponse::new)
                .collect(Collectors.toList());
    }

}
