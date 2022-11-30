package com.project.restapiboard.entity;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@SequenceGenerator(
        name = "BOARD_SEQ_GENERATOR"
        , sequenceName = "BOARD_SEQ"
        , initialValue = 1
        , allocationSize = 1
)
@Table(name = "board")
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "BOARD_SEQ_GENERATOR")
    private Long board_no;

    private String board_subject;
    private String board_content;
    private String board_upload;
    private String board_oldfilename;
    private String board_newfilename;

    private int ref;
    private int re_step;
    private int re_level;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id") // user 테이블의 PK를 조인.
    private User user;


    @ManyToOne
    @JoinColumn(name = "boardtype_no")
    private BoardType boardType;

}
