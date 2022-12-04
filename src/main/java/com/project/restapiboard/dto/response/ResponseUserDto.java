package com.project.restapiboard.dto.response;

import com.project.restapiboard.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseUserDto {

    private String user_id;
    private String user_pass;
    private String user_email;

    public ResponseUserDto(User user) {
       this.user_id = user.getUser_id();
       this.user_pass = user.getUser_pass();
       this.user_email = user.getUser_email();
    }
}
