package com.project.restapiboard.dto.response;

import com.project.restapiboard.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResBoardeListDto {

    private long boardNo;
    private String boardSubject;
    private String boardContent;
    private String boardUpload;
    private String boardOldfilename;
    private String boardNewfilename;
    private long boardCount;
    private String boardCreate;
//    private LocalDateTime boardCreate;
    private String boardRevision;
    private int ref;
    private int reStep;
    private int reLevel;
    private String userId;
    private long typeNo;

    public ResBoardeListDto(Board board){
        this.boardNo = board.getBoardNo();
        this.boardSubject = board.getBoardSubject();
        this.boardContent = board.getBoardContent();
        this.boardUpload = board.getBoardUpload();
        this.boardOldfilename = board.getBoardOldfilename();
        this.boardNewfilename = board.getBoardNewfilename();
        this.boardCount = board.getBoardCount();
        this.boardCreate = board.getBoardCreate();
//        this.boardCreate = board.getBoardCreate();
        this.boardRevision = board.getBoardRevision();
        this.ref =board.getRef();
        this.reStep = board.getReStep();
        this.reLevel = board.getReLevel();
        this.userId = board.getUser().getUserId();
        this.typeNo = board.getType().getTypeNo();
    }

}
