package com.project.restapiboard.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@EntityListeners(AuditingEntityListener.class)
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
    @Column(name = "board_no")
    private long boardNo;

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

    @Column(name = "board_count")
    @ColumnDefault("0")
    private long boardCount;

    @Column(name = "board_create")
    @CreatedDate
    private String boardCreate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY.MM.DD"));
//    private LocalDateTime boardCreate;

    @Column(name = "board_revision")
    @LastModifiedDate
    private String boardRevision = LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY.MM.DD"));
//    private LocalDateTime boardRevision;

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
    @JoinColumn(name = "type_no", foreignKey = @ForeignKey(name = "FK_BOARDTYPE_NO"))
    private Type type;

    @Builder
    public Board(long boardNo, String boardSubject, String boardContent, String boardUpload, String boardOldfilename,
                 String boardNewfilename, long boardCount, String boardCreate, String boardRevision,
                 int ref, int reStep, int reLevel, User user, Type type) {

        this.boardNo = boardNo;
        this.boardSubject = boardSubject;
        this.boardContent = boardContent;
        this.boardUpload = boardUpload;
        this.boardOldfilename = boardOldfilename;
        this.boardNewfilename = boardNewfilename;
        this.boardCount = boardCount;
        this.boardCreate = boardCreate;
        this.boardRevision = boardRevision;
        this.ref = ref;
        this.reStep = reStep;
        this.reLevel = reLevel;
        this.user = user;
        this.type = type;
    }




}
