package com.project.restapiboard.dto.response;

import com.project.restapiboard.entity.Type;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseTypeDto {
    private long boardtypeNo;
    private String boardtypeName;

    public ResponseTypeDto(Type type) {
        this.boardtypeNo = type.getTypeNo();
        this.boardtypeName = type.getTypeName();
    }
}

