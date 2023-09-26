package com.dongsuri.admin.repository;

import com.dongsuri.admin.domain.Board;
import com.dongsuri.admin.domain.enumFile.Categories;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    BoardRepository boardRepository;

    @After
    public void cleanup(){
        boardRepository.deleteAll();;
    }

    @Test
    public void 게시글저장_불러오기(){
        //given
        String title = "테스트게시글";
        String content = "테스트 본문";
        int viewCount = 1;
        Categories categories = Categories.NOTICE;

        boardRepository.save(Board.builder()
                        .title(title)
                        .content(content)
                        .author("rjs2021@gmail.com")
                        .viewCount(viewCount)
                        .categories(categories)
                .build()
        );
        //when
        List<Board> boardsList = boardRepository.findAll();

        //then
        Board board = boardsList.get(0);
        assertThat(board.getTitle()).isEqualTo(title);
        assertThat(board.getContent()).isEqualTo(content);
        assertThat(board.getCategories()).isEqualTo(categories);
        assertThat(board.getViewCount()).isEqualTo(viewCount);
    }

}
