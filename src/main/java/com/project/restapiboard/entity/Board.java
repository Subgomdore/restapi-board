package com.project.restapiboard.entity;

import lombok.AccessLevel;
import lombok.Builder;
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
    @Column(name="board_no")
    private Long boardNo;

    @Column(name = "board_subject", nullable = false)
    private String boardSubject;

    @Column(name = "board_content", nullable = false)
    private String boardContent;

    @Column(name = "board_upload")
    private String boardUpload;

    @Column(name = "board_oldfilename")
    private String boardOldfilename;

    @Column(name = "board_newfilename")
    private String boardNewfilename;

    @Column(name = "ref")
    @ColumnDefault("0")
    private int ref;

    @Column(name = "re_step")
    @ColumnDefault("0")
    private int reStep;

    @Column(name = "re_level")
    @ColumnDefault("0")
    private int reLevel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "FK_USER_ID"))  // user 테이블의 PK를 조인.
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "type_no", foreignKey =  @ForeignKey(name = "FK_BOARDTYPE_NO"))
    private Type type;

    @Builder
    public Board(long boardNo, String boardSubject, String boardContent, String boardUpload, String boardOldfilename, String boardNewfilename,
                 int ref, int reStep, int reLevel) {
        this.boardNo = boardNo;
        this.boardSubject = boardSubject;
        this.boardContent = boardContent;
        this.boardUpload = boardUpload;
        this.boardOldfilename = boardOldfilename;
        this.boardNewfilename = boardNewfilename;
        this.ref = ref;
        this.reStep = reStep;
        this.reLevel = reLevel;

    }


}
