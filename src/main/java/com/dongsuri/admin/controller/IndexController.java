package com.dongsuri.admin.controller;

import com.dongsuri.admin.config.auth.LoginUser;
import com.dongsuri.admin.config.auth.dto.SessionUser;
import com.dongsuri.admin.domain.Board;
import com.dongsuri.admin.dto.BoardResponseDto;
import com.dongsuri.admin.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final HttpSession httpSession;
    private final BoardService boardService;

    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        if(user != null){
            model.addAttribute("userName", user.getName());
        }
        return "index";
    }

    @GetMapping("/board/save")
    public String boardSave(){
        return "board-save";
    }

    @GetMapping("/board/update/{id}")
    public String boardUpdate(@PathVariable Long id, Model model){
        BoardResponseDto dto = boardService.findById(id);
        model.addAttribute("board", dto);

        return "board-update";
    }
}