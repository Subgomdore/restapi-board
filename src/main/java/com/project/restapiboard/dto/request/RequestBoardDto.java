package com.project.restapiboard.dto.request;

import com.project.restapiboard.entity.Board;
import com.project.restapiboard.entity.Type;
import com.project.restapiboard.entity.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RequestBoardDto {

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
    private User user;
    private Type type;

    public Board toEntity() {
        return Board.builder()
                .boardSubject(boardSubject)
                .boardContent(boardContent)
                .boardUpload(boardUpload)
                .boardOldfilename(boardOldfilename)
                .boardNewfilename(boardNewfilename)
                .ref(ref)
                .reStep(reStep)
                .reLevel(reLevel)
                .user(user)
                .type(type)
                .build();
    }



}
