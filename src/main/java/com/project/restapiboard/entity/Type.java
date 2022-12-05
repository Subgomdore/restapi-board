package com.project.restapiboard.entity;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@SequenceGenerator(
        name = "BOARDTYPE_SEQ_GENERATOR"
        , sequenceName = "TYPE_SEQ"
        , initialValue = 1001
        , allocationSize = 1
)

public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE
            , generator = "TYPE_SEQ_GENERATOR")
    @Column(name = "type_no")
    private Long typeNo;

    @Column(name = "type_name")
    private String typeName;

    @OneToMany(mappedBy = "type")
    private List<Board> board = new ArrayList<>();

    @Builder
    public Type(String typeName) {
        this.typeName = typeName;
    }


}
