package com.dongsuri.admin.controller;

import com.dongsuri.admin.domain.Board;
import com.dongsuri.admin.domain.enumFile.Categories;
import com.dongsuri.admin.dto.boardDto.BoardSaveRequestDto;
import com.dongsuri.admin.dto.boardDto.BoardUpdateRequestDto;
import com.dongsuri.admin.repository.BoardRepository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity; //5.7추가
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class BoardControllerTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @Before
    public void setup(){
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @After
    public void tearDown() throws Exception{
        boardRepository.deleteAll();
    }

    @Test
    @WithMockUser(roles="ADMIN")
    public void Board_등록된다() throws Exception{
        //given
        String title = "title";
        String content = "content";
        Categories categories = Categories.NOTICE;
        BoardSaveRequestDto requestDto = BoardSaveRequestDto.builder()
                .title(title)
                .content(content)
                .author("author")
                .categories(categories)
                .build();

        String url = "http://localhost:" + port + "/api/v1/board";

        //when
        mvc.perform(post(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<Board> all = boardRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);
        assertThat(all.get(0).getCategories()).isEqualTo(categories);
    }

    @Test
    @WithMockUser(roles="ADMIN")
    public void Board_수정된다() throws Exception{
        //given
        Board savedBoard = boardRepository.save(Board.builder()
                        .title("title")
                        .content("content")
                        .author("author")
                        .viewCount(1)
                        .categories(Categories.NOTICE)
                .build());

        Long updateId = savedBoard.getId();
        String expectedTitle = "title2";
        String expectedContent = "content2";
        Categories expectedCategories = Categories.DATA_ARCHIVE;

        BoardUpdateRequestDto requestDto = BoardUpdateRequestDto.builder()
                .title(expectedTitle)
                .content(expectedContent)
                .categories(expectedCategories)
                .build();

        String url = "http://localhost:"+ port + "/api/v1/board/" + updateId;

        //when
        mvc.perform(put(url)
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(new ObjectMapper().writeValueAsString(requestDto)))
                .andExpect(status().isOk());

        //then
        List<Board> all = boardRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(expectedTitle);
        assertThat(all.get(0).getContent()).isEqualTo(expectedContent);
        assertThat(all.get(0).getCategories()).isEqualTo(expectedCategories);
    }
}
