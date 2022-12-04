package com.project.restapiboard.dto.request;

import com.project.restapiboard.entity.BoardType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RequestBoardTypeDto {

    private String boardtype_name;

    @Builder
    public RequestBoardTypeDto(long boardtype_no, String boardTypeName) {
        this.boardtype_name = boardTypeName;

    }

    public BoardType toEntity() {
        return BoardType.builder()
                .boardtype_name(boardtype_name)
                .build();
    }

}
