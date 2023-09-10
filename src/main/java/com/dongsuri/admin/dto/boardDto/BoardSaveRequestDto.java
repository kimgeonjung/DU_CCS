package com.dongsuri.admin.dto.boardDto;

import com.dongsuri.admin.domain.Board;
import com.dongsuri.admin.domain.enumFile.Categories;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class BoardSaveRequestDto {
    private String title;
    private String content;
    private String author;
    private Categories categories;
    @Builder
    public BoardSaveRequestDto(String title, String content, String author, Categories categories){
        this.title = title;
        this.content = content;
        this.author = author;
        this.categories = categories;
    }

    public Board toEntity(){
        return Board.builder()
                .title(title)
                .content(content)
                .author(author)
                .categories(categories)
                .build();
    }
}
