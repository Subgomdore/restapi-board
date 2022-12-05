package com.project.restapiboard.entity;


import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class User {

    @Id
    @Column(name = "user_id")
    private String userId;

    @NotNull
    @Column(name = "user_pass")
    private String userPass;

    @NotNull
    @Column(name = "user_email")
    private String userEmail;

    @OneToMany(mappedBy = "user")
    private List<Board> boards = new ArrayList<>();

    @Builder
    public User(String userId, String userPass, String userEmail) {
        this.userId = userId;
        this.userPass = userPass;
        this.userEmail = userEmail;
    }

}