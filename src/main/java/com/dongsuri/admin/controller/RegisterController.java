package com.dongsuri.admin.controller;

import com.dongsuri.admin.dto.memberDto.MemberListResponseDto;
import com.dongsuri.admin.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class RegisterController {
    private final MemberService memberService;

    @GetMapping("/registers/registerList")
    public String showRegisterListPage(Model model){
        List<MemberListResponseDto> memberListResponseDto = memberService.findAllDesc();
        model.addAttribute("register", memberListResponseDto);
        return "registers/registerList";
    }
}
