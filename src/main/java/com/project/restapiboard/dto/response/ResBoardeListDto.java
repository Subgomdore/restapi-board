package com.project.restapiboard.dto.response;

import com.project.restapiboard.entity.Board;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResBoardeListDto {

    private long boardNo;
    private String boardSubject;
    private String boardContent;
    private String boardUpload;
    private String boardOldfilename;
    private String boardNewfilename;
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
        this.ref =board.getRef();
        this.reStep = board.getReStep();
        this.reLevel = board.getReLevel();
        this.userId = board.getUser().getUserId();
        this.typeNo = board.getType().getTypeNo();
    }

}
