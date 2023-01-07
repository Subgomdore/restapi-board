package com.project.restapiboard.service;

import com.project.restapiboard.dto.request.ReqPagingDto;
import com.project.restapiboard.dto.response.ResPagingDto;
import com.project.restapiboard.entity.Board;
import com.project.restapiboard.entity.Type;
import com.project.restapiboard.repository.PageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class PageService {
    
    @Autowired
    PageRepository pageRepository;


    /*게시물 페이징*/
    public ResPagingDto getPaging(ReqPagingDto reqPagingDto) {

        int pageNumber = reqPagingDto.getPage();
        int pageSize = reqPagingDto.getPageSize();

        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, Sort.by(Sort.Direction.DESC,"boardNo"));
        Type type = Type.builder().typeNo(reqPagingDto.getTypeNo()).build();
        Page<Board> page = pageRepository.findByType(type, pageRequest); // typeNo 로 검색된 데이터의 페이징

        ResPagingDto pagingDto = new ResPagingDto();
        pagingDto.setTotalPages(page.getTotalPages());
        pagingDto.setTotalElements(page.getTotalElements());

        return pagingDto;
    }
}
