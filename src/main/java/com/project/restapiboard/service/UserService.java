package com.project.restapiboard.service;

import com.project.restapiboard.dto.request.RequestUserDto;
import com.project.restapiboard.dto.response.ResponseUserDto;
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

    public List<ResponseUserDto> getUserList() {

        // mapper 랑 stream(lamda)로 List를 치환하는방법이 있는데 아직 이해가안됨.
        List<User> userList = userRepository.findAll();                 // Entity 클래스로 전체사용자를 반환받음
        List<ResponseUserDto> responseUserDtoList = new ArrayList<>();  // response 객체 생성 및 초기화
        for (User user : userList) {                                    // 조회된 userlist 값을 루프돌려서
            ResponseUserDto responseUserDto = new ResponseUserDto(user);// 각 인덱스를 Response 매개변수로 넣고 Entity->Dto 치환
            responseUserDtoList.add(responseUserDto);                   // 생성된 DTO 객체를 DTO list에 추가
        }

        return responseUserDtoList;                                     // DTO로 치환된 DTOlist 리턴
    }

    /*회원가입 -> 유저등록*/
    /*UserDTO 로 값을 전달받음 -> EntityClass User로 변환 -> DB접속*/
    public void save(RequestUserDto requestUserDto) {
        User user = requestUserDto.toEntity();
//        userDTO = user.toDto();
        userRepository.save(user);
    }

    /*아이디 중복검사*/
    public boolean idCheck(RequestUserDto requestUserDto) {
        Optional<User> idCheck = userRepository.findById(requestUserDto.getUserId());
        return idCheck.isPresent(); // boolean형이라 dto로 치환하지않았음. 치환해서 체크해야하는건지 잘모름..(boolean이라 상관없을거같다는판단)
    }

    /*비밀번호 체크*/
    public ResponseUserDto loginCheck(RequestUserDto requestUserDto) {
        User user = requestUserDto.toEntity();                                      //DTO -> Entity build
        Optional<User> loginUser = userRepository.findById(user.getUserId());
        ResponseUserDto responseUserDto = new ResponseUserDto(loginUser.get());     // Optional longinUser를 다시 DTO로 치환.
        return responseUserDto;
    }

}
