package com.project.restapiboard.dto.response;

import com.project.restapiboard.entity.Type;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseTypeDto {
    private long typeNo;
    private String typeName;

    public ResponseTypeDto(Type type) {
        this.typeNo = type.getTypeNo();
        this.typeName = type.getTypeName();
    }
}

