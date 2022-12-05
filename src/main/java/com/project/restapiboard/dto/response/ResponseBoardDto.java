package com.project.restapiboard.dto.response;

import com.project.restapiboard.entity.Board;

public class ResponseBoardDto {
    private long boardNo;
    private String boardSubject;
    private String boardContent;
    private String boardUpload;
    private String boardOldfilename;
    private String boardNewfilename;
    private int ref;
    private int reStep;
    private int reLevel;

    public ResponseBoardDto(Board board) {
        this.boardNo = board.getBoardNo();
        this.boardSubject = board.getBoardSubject();
        this.boardContent = board.getBoardContent();
        this.boardUpload = board.getBoardUpload();
        this.boardOldfilename = board.getBoardOldfilename();
        this.boardNewfilename = board.getBoardNewfilename();
        this.ref = board.getRef();
        this.reStep = board.getReStep();
        this.reLevel = board.getReLevel();
    }
}
