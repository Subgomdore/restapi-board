package com.project.restapiboard.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReqPagingDto {

    private long typeNo;
    private long totalPages;
    private long totalElements;
    private int startPage;
    private int endPage;
    private int page;
    private int pageSize;

}
