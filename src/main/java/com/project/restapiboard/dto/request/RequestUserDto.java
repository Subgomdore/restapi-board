package com.project.restapiboard.dto.request;

import com.project.restapiboard.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RequestUserDto {

    private String userId;
    private String userPass;
    private String userEmail;

    /** 점층적 생성자 패턴, Bilder를 사용하고있긴한데 왜 쓰는지 아직 이해못함.
    public void RequestUserDto() {
    }

    public RequestUserDto(String userId) {
        this.userId = userId;
    }

    public RequestUserDto(String userId, String userPass) {
        this.userId = userId;
        this.userPass = userPass;
    }

    public RequestUserDto(String userId, String userPass, String userEmail) {
        this.userId = userId;
        this.userPass = userPass;
        this.userEmail = userEmail;
    }
     */

    public User toEntity() {
        return User.builder()
                .userId(userId)
                .userPass(userPass)
                .userEmail(userEmail)
                .build();
    }
}
