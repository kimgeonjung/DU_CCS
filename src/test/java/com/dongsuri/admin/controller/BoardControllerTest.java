package com.dongsuri.admin.controller;

import com.dongsuri.admin.domain.Board;
import com.dongsuri.admin.dto.BoardSaveRequestDto;
import com.dongsuri.admin.dto.BoardUpdateRequestDto;
import com.dongsuri.admin.repository.BoardRepository;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType; //5.7추가
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc; //5.7추가
import org.springframework.test.web.servlet.setup.MockMvcBuilders; //5.7추가
import org.springframework.security.test.context.support.WithMockUser; //5.7추가
import org.springframework.web.context.WebApplicationContext; //5.7추가

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.failBecauseExceptionWasNotThrown;

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

    @After
    public void tearDown() throws Exception{
        boardRepository.deleteAll();
    }

    @Test
    public void Board_등록된다() throws Exception{
        //given
        String title = "title";
        String content = "content";
        BoardSaveRequestDto requestDto = BoardSaveRequestDto.builder()
                .title(title)
                .content(content)
                .author("author")
                .build();

        String url = "http://localhost:" + port + "/api/v1/board";

        //when
        ResponseEntity<Long> responseEntity = restTemplate.postForEntity(url, requestDto, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Board> all = boardRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(title);
        assertThat(all.get(0).getContent()).isEqualTo(content);
    }

    @Test
    public void Board_수정된다() throws Exception{
        //given
        Board savedBoard = boardRepository.save(Board.builder()
                        .title("title")
                        .content("content")
                        .author("author")
                .build());

        Long updateId = savedBoard.getId();
        String expectedTitle = "title2";
        String expectedContent = "content2";

        BoardUpdateRequestDto requestDto = BoardUpdateRequestDto.builder()
                .title(expectedTitle)
                .content(expectedContent)
                .build();

        String url = "http://localhost:"+ port + "/api/v1/board/" + updateId;
        HttpEntity<BoardUpdateRequestDto> requestEntity = new HttpEntity<>(requestDto);

        //when
        ResponseEntity<Long> responseEntity = restTemplate.exchange(url, HttpMethod.PUT, requestEntity, Long.class);

        //then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isGreaterThan(0L);

        List<Board> all = boardRepository.findAll();
        assertThat(all.get(0).getTitle()).isEqualTo(expectedTitle);
        assertThat(all.get(0).getContent()).isEqualTo(expectedContent);
    }
}
