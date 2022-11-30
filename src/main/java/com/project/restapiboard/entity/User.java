package com.project.restapiboard.entity;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)


public class User {

    @Id
    @Column(name = "user_id")
    private String user_id;

    @NotNull
    private String user_pass;
    @NotNull
    private String user_email;

    @OneToMany(mappedBy = "user")
    private List<Board> boardList = new ArrayList<Board>();

}