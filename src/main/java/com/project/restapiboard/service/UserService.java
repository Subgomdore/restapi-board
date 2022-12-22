package com.project.restapiboard.service;

import com.project.restapiboard.dto.request.ReqUserDto;
import com.project.restapiboard.dto.response.ResUserDto;
import com.project.restapiboard.entity.User;
import com.project.restapiboard.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<ResUserDto> getUserList() {

        // mapper 랑 stream(lamda)로 List를 치환하는방법이 있는데 아직 이해가안됨.
        List<User> userList = userRepository.findAll();                 // Entity 클래스로 전체사용자를 반환받음
        List<ResUserDto> resUserDtoList = new ArrayList<>();  // response 객체 생성 및 초기화
        for (User user : userList) {                                    // 조회된 userlist 값을 루프돌려서
            ResUserDto resUserDto = new ResUserDto(user);// 각 인덱스를 Response 매개변수로 넣고 Entity->Dto 치환
            resUserDtoList.add(resUserDto);                   // 생성된 DTO 객체를 DTO list에 추가
        }

        return resUserDtoList;                                     // DTO로 치환된 DTOlist 리턴
    }

    /*회원가입 -> 유저등록*/
    /*UserDTO 로 값을 전달받음 -> EntityClass User로 변환 -> DB접속*/
    public void save(ReqUserDto reqUserDto) {
        User user = reqUserDto.toEntity();
//        userDTO = user.toDto();
        userRepository.save(user);
    }

    /*아이디 중복검사*/
    public boolean idCheck(ReqUserDto reqUserDto) {
        Optional<User> idCheck = userRepository.findById(reqUserDto.getUserId());
        return idCheck.isPresent(); // boolean형이라 dto로 치환하지않았음. 치환해서 체크해야하는건지 잘모름..(boolean이라 상관없을거같다는판단)
    }

    /*비밀번호 체크*/
    public ResUserDto loginCheck(ReqUserDto reqUserDto) {
        User user = reqUserDto.toEntity();                                      //DTO -> Entity build
        Optional<User> loginUser = userRepository.findById(user.getUserId());
        ResUserDto resUserDto = new ResUserDto(loginUser.get());     // Optional longinUser를 다시 DTO로 치환.
        return resUserDto;
    }

}
