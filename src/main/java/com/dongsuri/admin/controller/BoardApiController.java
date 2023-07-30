package com.dongsuri.admin.controller;

import com.dongsuri.admin.dto.BoardListResponseDto;
import com.dongsuri.admin.dto.BoardResponseDto;
import com.dongsuri.admin.dto.BoardSaveRequestDto;
import com.dongsuri.admin.dto.BoardUpdateRequestDto;
import com.dongsuri.admin.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class BoardApiController {
    private final BoardService boardService;

    @PostMapping("/api/v1/board")
    public Long save(@RequestBody BoardSaveRequestDto requestDto){
        return boardService.save(requestDto);
    }

    @PutMapping("/api/v1/board/{id}")
    public Long update(@PathVariable Long id, @RequestBody BoardUpdateRequestDto requestDto){
        return boardService.update(id, requestDto);
    }

    @DeleteMapping("/api/v1/board/{id}")
    public Long delete(@PathVariable Long id){
        boardService.delete(id);
        return id;
    }

    @GetMapping("/api/v1/board/{id}")
    public BoardResponseDto findById (@PathVariable Long id){
        return boardService.findById(id);
    }

}
