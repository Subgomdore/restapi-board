package com.project.restapiboard.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "board")
public class Board {

    @Id
    private Long board_no;

    private String board_subject;
    private String board_content;
    private String board_upload;
    private String board_oldfilename;
    private String board_newfilename;

    private int ref;
    private int re_step;
    private int re_level;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "boardtype_no")
    private BoardType boardType;

}
