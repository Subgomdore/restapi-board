package com.project.restapiboard.entity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
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

    @Column(nullable = false)
    private String board_subject;

    @Column(nullable = false)
    private String board_content;

    private String board_upload;
    private String board_oldfilename;
    private String board_newfilename;

    @ColumnDefault("0")
    private int ref;

    @ColumnDefault("0")
    private int re_step;

    @ColumnDefault("0")
    private int re_level;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_USER_ID"))  // user 테이블의 PK를 조인.
    private User user;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "boardtype_no", foreignKey =  @ForeignKey(name = "FK_BOARDTYPE_NO"))
    private BoardType boardType;

//    @Builder
//    public Board(long board_no, String board_subject, String board_content, String board_upload, String board_oldfilename, String board_newfilename,
//                 int ref, int re_step, int re_level) {
//        this.board_no = board_no;
//        this.board_subject = board_subject;
//        this.board_content = board_content;
//        this.board_upload = board_upload;
//        this.board_oldfilename = board_oldfilename;
//        this.board_newfilename = board_newfilename;
//        this.ref = ref;
//        this.re_step = re_step;
//        this.re_level = re_level;
//
//    }


}
