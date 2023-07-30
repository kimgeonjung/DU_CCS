package com.dongsuri.admin.dto;

import com.dongsuri.admin.domain.Board;
import com.dongsuri.admin.domain.enumFile.Categorys;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class BoardResponseDto {
    private Long id;
    private Categorys categorys;
    private String title;
    private String content;
    private String author;
    private int viewCount;


    public BoardResponseDto(Board entity){
        this.id = entity.getId();
        this.categorys = entity.getCategorys();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.author = entity.getAuthor();
        this.viewCount = entity.getViewCount();
    }
}
