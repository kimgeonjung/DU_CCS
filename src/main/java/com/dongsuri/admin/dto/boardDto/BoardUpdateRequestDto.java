package com.dongsuri.admin.dto.boardDto;

import com.dongsuri.admin.domain.enumFile.Categorys;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardUpdateRequestDto {
    private String title;
    private String content;
    private Categorys categorys;

    @Builder
    public BoardUpdateRequestDto(String title, String content, Categorys categorys){
        this.title = title;
        this.content = content;
        this.categorys = categorys;
    }
}
