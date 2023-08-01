package com.dongsuri.admin.controller;

import com.dongsuri.admin.dto.BoardListResponseDto;
import com.dongsuri.admin.dto.BoardResponseDto;
import com.dongsuri.admin.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/boards/boardList")
    public String showBoardListPage(Model model){
        List<BoardListResponseDto> boardListResponseDto = boardService.findAllDesc();
        model.addAttribute("board", boardListResponseDto);
        return "boards/boardList";
    }

    @GetMapping("/boards/board/save")
    public String boardSave(){
        return "boards/board-save";
    }

    @GetMapping("/boards/board/update/{id}")
    public String boardUpdate(@PathVariable Long id, Model model){
        BoardResponseDto dto = boardService.findById(id);
        model.addAttribute("board", dto);

        return "/boards/board-update";
    }

    @GetMapping("/boards/board/detail/{id}")
    public String showBoardPage(@PathVariable Long id, Model model){
        BoardResponseDto dto = boardService.findById(id);
        model.addAttribute("board", dto);
        return "boards/board-detail";
    }

}
