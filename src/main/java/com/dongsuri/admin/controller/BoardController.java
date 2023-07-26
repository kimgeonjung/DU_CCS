package com.dongsuri.admin.controller;

import com.dongsuri.admin.dto.BoardListResponseDto;
import com.dongsuri.admin.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/boards/notice")
    public String showBoardPage(Model model){
        List<BoardListResponseDto> boardListResponseDto = boardService.findAllDesc();
        model.addAttribute("board", boardListResponseDto);
        return "boards/notice";
    }
}
