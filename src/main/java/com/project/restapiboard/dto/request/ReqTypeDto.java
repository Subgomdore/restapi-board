package com.project.restapiboard.dto.request;

import com.project.restapiboard.entity.Type;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class ReqTypeDto {

    private long typeNo;
    private String typeName;

    public Type toEntity() {
        return Type.builder()
                .typeName(typeName)
                .build();
    }

}
