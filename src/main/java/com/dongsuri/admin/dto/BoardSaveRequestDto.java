package com.dongsuri.admin.dto;

import com.dongsuri.admin.domain.Board;
import com.dongsuri.admin.domain.enumFile.Categorys;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class BoardSaveRequestDto {
    private String title;
    private String content;
    private String author;
    private Categorys categorys;
    @Builder
    public BoardSaveRequestDto(String title, String content, String author, Categorys categorys){
        this.title = title;
        this.content = content;
        this.author = author;
        this.categorys = categorys;
    }

    public Board toEntity(){
        return Board.builder()
                .title(title)
                .content(content)
                .author(author)
                .categorys(categorys)
                .build();
    }
}
