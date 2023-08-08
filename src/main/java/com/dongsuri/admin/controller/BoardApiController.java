package com.dongsuri.admin.controller;

import com.dongsuri.admin.dto.boardDto.BoardResponseDto;
import com.dongsuri.admin.dto.boardDto.BoardSaveRequestDto;
import com.dongsuri.admin.dto.boardDto.BoardUpdateRequestDto;
import com.dongsuri.admin.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/board")
public class BoardApiController {
    private final BoardService boardService;

    @PostMapping
    public Long save(@RequestBody BoardSaveRequestDto requestDto){
        return boardService.save(requestDto);
    }

    @PutMapping("/{id}")
    public Long update(@PathVariable Long id, @RequestBody BoardUpdateRequestDto requestDto){
        return boardService.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public Long delete(@PathVariable Long id){
        boardService.delete(id);
        return id;
    }

    @GetMapping("/{id}")
    public BoardResponseDto findById (@PathVariable Long id){
        return boardService.findById(id);
    }

}
