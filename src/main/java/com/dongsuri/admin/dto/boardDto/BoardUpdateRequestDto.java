package com.dongsuri.admin.dto.boardDto;

import com.dongsuri.admin.domain.enumFile.Categories;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardUpdateRequestDto {
    private String title;
    private String content;
    private Categories categories;

    @Builder
    public BoardUpdateRequestDto(String title, String content, Categories categories){
        this.title = title;
        this.content = content;
        this.categories = categories;
    }
}
