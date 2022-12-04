package com.project.restapiboard.entity;


import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id
    @Column(name = "user_id")
    private String user_id;

    @NotNull
    private String user_pass;
    @NotNull
    private String user_email;

    @Builder
    public User(String user_id, String user_pass, String user_email) {
        this.user_id = user_id;
        this.user_pass = user_pass;
        this.user_email = user_email;
    }

}