package com.project.restapiboard.dto.request;

import com.project.restapiboard.entity.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RequestUserDto {

    private String user_id;
    private String user_pass;
    private String user_email;

    @Builder
    public RequestUserDto(String user_id, String user_pass, String user_email) {
        this.user_id = user_id;
        this.user_pass = user_pass;
        this.user_email = user_email;
    }

    public User toEntity() {
        return User.builder()
                .user_id(user_id)
                .user_pass(user_pass)
                .user_email(user_email)
                .build();
    }
}
