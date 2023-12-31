package com.dongsuri.admin.domain;

import com.dongsuri.admin.domain.enumFile.Categories;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotBlank;

//게시판 데이터베이스
@Getter
@NoArgsConstructor
@Entity
public class Board extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long board_id;

    @NotBlank(message = "제목을 입력하세요.")
    @Size(max = 500, message = "제목은 500자까지 입력 가능합니다.")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "내용을 입력하세요.")
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @NotBlank(message = "작성자를 입력하세요.")
    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private int viewCount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Categories categories;

    @Builder
    public Board(String title, String content, String author, int viewCount, Categories categories){
        this.title = title;
        this.content = content;
        this.author = author;
        this.viewCount = viewCount;
        this.categories = categories;
    }

    public void update(String title, String content, Categories categories){
        this.title = title;
        this.content = content;
        this.categories = categories;
    }

    public void increaseViewCount(){
        this.viewCount++;
    }

    public Long getId() {
        return board_id;
    }
}