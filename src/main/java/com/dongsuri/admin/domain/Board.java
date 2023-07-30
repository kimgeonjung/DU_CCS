package com.dongsuri.admin.domain;

import com.dongsuri.admin.domain.enumFile.Categorys;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

//게시판 데이터베이스
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Board extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long board_id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private int viewCount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Categorys categorys;

    @Builder
    public Board(String title, String content, String author, int viewCount, Categorys categorys){
        this.title = title;
        this.content = content;
        this.author = author;
        this.viewCount = viewCount;
        this.categorys = categorys;
    }

    public void update(String title, String content, Categorys categorys){
        this.title = title;
        this.content = content;
        this.categorys = categorys;
    }

    public Long getId() {
        return board_id;
    }
}