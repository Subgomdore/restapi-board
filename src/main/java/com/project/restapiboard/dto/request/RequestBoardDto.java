package com.project.restapiboard.dto.request;

import com.project.restapiboard.entity.Board;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RequestBoardDto {

    private Long boardNo;
    private String boardSubject;
    private String boardContent;
    private String boardUpload;
    private String boardOldfilename;
    private String boardNewfilename;
    private int ref;
    private int reStep;
    private int reLevel;

    public Board toEntity() {
        return Board.builder()
                .boardNo(boardNo)
                .boardContent(boardContent)
                .boardUpload(boardUpload)
                .boardOldfilename(boardOldfilename)
                .boardNewfilename(boardNewfilename)
                .ref(ref)
                .reStep(reStep)
                .reLevel(reLevel)
                .build();
    }
}
