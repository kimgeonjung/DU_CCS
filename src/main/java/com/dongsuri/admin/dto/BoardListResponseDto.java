package com.dongsuri.admin.dto;

import com.dongsuri.admin.domain.Board;
import com.dongsuri.admin.domain.enumFile.Categorys;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardListResponseDto {
    private Long id;
    private Categorys categorys;
    private String title;
    private int viewCount;
    private LocalDateTime modifiedDate;

    public BoardListResponseDto(Board entity){
        this.id = entity.getId();
        this.categorys = entity.getCategorys();
        this.title = entity.getTitle();
        this.viewCount = entity.getViewCount();
        this.modifiedDate = entity.getModifiedDate();
    }
}
