package com.dongsuri.admin.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
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

    private String author;

    private int views;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Categorys categorys;

    @Builder
    public Board(String title, String content, String author, int views, Categorys categorys){
        this.title = title;
        this.content = content;
        this.author = author;
        this.views = views;
        this.categorys = categorys;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

    public Long getId() {
        return board_id;
    }
}