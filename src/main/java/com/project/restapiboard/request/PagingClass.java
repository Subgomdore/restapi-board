package com.project.restapiboard.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PagingClass {

    private static final int Max_SIZE = 2000;

    @Builder.Default
    private Integer page = 1;

    @Builder.Default
    private Integer size = 5;

    public long getOffset(){
        return (long)(Math.max(1,page)-1)*Math.min(size,Max_SIZE);
    }

}
