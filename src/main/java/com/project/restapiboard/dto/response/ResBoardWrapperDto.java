package com.project.restapiboard.dto.response;

import com.project.restapiboard.entity.Board;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class ResBoardWrapperDto {
    List<ResBoardDto> list;
    ResPagingDto paging;
}
