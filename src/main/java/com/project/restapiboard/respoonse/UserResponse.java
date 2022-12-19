package com.project.restapiboard.respoonse;

import com.project.restapiboard.entity.User;
import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class UserResponse {

    private final String userId;
    private final String nickName;
    private final String userPass;
    private final String userEmail;
    private final String role;
    private final String provider;
    private final String providerId;
    private final Timestamp createDate;

    public UserResponse(User user) {
        this.userId = user.getUserId();
        this.nickName = user.getNickName();
        this.userPass = user.getUserPass();
        this.userEmail = user.getUserEmail();
        this.role = user.getRole();
        this.provider = user.getProvider();
        this.providerId = user.getProviderId();
        this.createDate = user.getCreateDate();
    }

    @Builder
    public UserResponse(String userId, String nickName, String userPass, String userEmail, String role, String provider, String providerId, Timestamp createDate) {
        this.userId = userId.substring(0,Math.min(userId.length(),10));
        this.nickName = nickName;
        this.userPass = userPass;
        this.userEmail = userEmail;
        this.role = role;
        this.provider = provider;
        this.providerId = providerId;
        this.createDate = createDate;
    }
}
