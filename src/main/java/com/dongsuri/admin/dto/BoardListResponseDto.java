package com.dongsuri.admin.dto;

import com.dongsuri.admin.domain.Board;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class BoardListResponseDto {
    private Long id;
    private String title;
    private String author;
    private LocalDateTime modifiedDate;

    public BoardListResponseDto(Board entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.modifiedDate = entity.getModifiedDate();
    }
}
