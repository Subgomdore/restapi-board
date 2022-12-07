package com.project.restapiboard.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="boardType1003")
public class BoardType {

    @Id
    private Long boardId;
    private String boardName;
}
