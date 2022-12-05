package com.project.restapiboard.dto.response;

import com.project.restapiboard.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseUserDto {

    private String userId;
    private String userPass;
    private String userEmail;

    public ResponseUserDto(User user) {
       this.userId = user.getUserId();
       this.userPass = user.getUserPass();
       this.userEmail = user.getUserEmail();
    }
}
