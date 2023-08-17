package com.dongsuri.admin.controller;

import com.dongsuri.admin.dto.boardDto.BoardResponseDto;
import com.dongsuri.admin.dto.registerDto.RegisterListResponseDto;
import com.dongsuri.admin.dto.registerDto.RegisterResponseDto;
import com.dongsuri.admin.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class RegisterController {
    private final MemberService memberService;

    @GetMapping("/registers/registerList")
    public String showRegisterListPage(Model model){
        List<RegisterListResponseDto> registerList = memberService.findAllDescWithRegisterRole();
        model.addAttribute("registerList", registerList);
        return "registers/registerList";
    }

    @GetMapping("/registers/register/detail/{id}")
    public String showRegisterPage(@PathVariable Long id, Model model){
        RegisterResponseDto register = memberService.findByIdRegister(id);
        model.addAttribute("register", register);
        return "registers/register-detail";
    }
}
