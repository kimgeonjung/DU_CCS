package com.dongsuri.admin.dto.boardDto;

import com.dongsuri.admin.domain.Board;
import com.dongsuri.admin.domain.enumFile.Categories;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardResponseDto {
    private Long id;
    private Categories categories;
    private String title;
    private String content;
    private String author;
    private int viewCount;


    public BoardResponseDto(Board entity){
        this.id = entity.getId();
        this.categories = entity.getCategories();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.viewCount = entity.getViewCount();
    }
}
