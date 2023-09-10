package com.dongsuri.admin.dto.boardDto;

import com.dongsuri.admin.domain.Board;
import com.dongsuri.admin.domain.enumFile.Categories;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardListResponseDto {
    private Long id;
    private Categories categories;
    private String title;
    private int viewCount;
    private LocalDateTime modifiedDate;

    public BoardListResponseDto(Board entity){
        this.id = entity.getId();
        this.categories = entity.getCategories();
        this.title = entity.getTitle();
        this.viewCount = entity.getViewCount();
        this.modifiedDate = entity.getModifiedDate();
    }
}
