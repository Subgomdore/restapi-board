package com.project.restapiboard.dto.response;

import com.project.restapiboard.entity.BoardType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseBoardTypeDto {
    private long boardtype_no;
    private String boardtype_name;

    public ResponseBoardTypeDto(BoardType boardType) {
        this.boardtype_no = boardType.getBoardtype_no();
        this.boardtype_name = boardType.getBoardtype_name();
    }
}

