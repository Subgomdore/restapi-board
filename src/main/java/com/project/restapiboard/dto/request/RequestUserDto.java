package com.project.restapiboard.dto.request;

import com.project.restapiboard.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RequestUserDto {

    private String userId;
    private String userPass;
    private String userEmail;


    public User toEntity() {
        return User.builder()
                .userId(userId)
                .userPass(userPass)
                .userEmail(userEmail)
                .build();
    }
}
