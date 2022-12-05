package com.project.restapiboard.dto.request;

import com.project.restapiboard.entity.Type;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RequestTypeDto {

    private String typeName;

    public Type toEntity() {
        return Type.builder()
                .typeName(typeName)
                .build();
    }

}
