package com.project.restapiboard.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@SequenceGenerator(
        name = "BOARDTYPE_SEQ_GENERATOR"
        , sequenceName = "BOARDTYPE_SEQ"
        , initialValue = 1001
        , allocationSize = 1
)

@Table(name = "boardtype")
public class BoardType {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "BOARDTYPE_SEQ_GENERATOR")
    private Long boardtype_no;

    private String boardtype_name;

}
