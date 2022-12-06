package com.project.restapiboard.dto.response;

import com.project.restapiboard.entity.Board;
import com.project.restapiboard.entity.Type;
import com.project.restapiboard.entity.User;

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
    private User user;
    private Type type;

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
        this.user = board.getUser();
        this.type = board.getType();
    }
}
