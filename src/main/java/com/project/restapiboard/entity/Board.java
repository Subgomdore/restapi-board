package com.project.restapiboard.entity;

import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "Board")
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

    @Embedded
    private User user;


}
