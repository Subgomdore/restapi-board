package com.project.restapiboard.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@SequenceGenerator(
        name = "BOARDTYPE_SEQ_GENERATOR"
        , sequenceName = "BOARDTYPE_SEQ"
        , initialValue = 1001
        , allocationSize = 1
)

public class BoardType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "BOARDTYPE_SEQ_GENERATOR")
    @Column(name = "boardtype_no")
    private Long boardtype_no;

    @Column(name = "boardtype_name")
    private String boardtype_name;

    @Builder
    public BoardType(String boardtype_name) {
        this.boardtype_name = boardtype_name;
    }


}
