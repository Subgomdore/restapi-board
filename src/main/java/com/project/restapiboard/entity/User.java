package com.project.restapiboard.entity;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @Id
    private String user_id;

    @NotNull
    private String user_pass;
    @NotNull
    private String user_email;

//    public User signIn(String user_id, String user_pass ){
//        this.user_id = user_id;
//        this.user_pass = user_pass;
//        return this;
//    }

    @Builder
    public User(String user_id, String user_pass, String user_email){
        this.user_id = user_id;
        this.user_pass = user_pass;
        this.user_email = user_email;
    }

//    @OneToMany(mappedBy = "board")
//    private List<Board> boards = new ArrayList<Board>();

}