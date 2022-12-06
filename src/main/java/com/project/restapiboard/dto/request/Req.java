package com.project.restapiboard.dto.request;

import com.project.restapiboard.entity.Board;
import com.project.restapiboard.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Req {

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

    public Board BoardtoEntity(){
        return Board.builder()
                .boardSubject(boardSubject)
                .boardContent(boardContent)
                .boardUpload(boardUpload)
                .boardOldfilename(boardOldfilename)
                .boardNewfilename(boardNewfilename)
                .ref(ref)
                .reStep(reStep)
                .reLevel(reLevel)
                .build();
    }

    public User UserIdtoEntity(){
        return User.builder()
                .userId(userId)
                .build();
    }

}
