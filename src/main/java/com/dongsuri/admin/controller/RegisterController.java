package com.dongsuri.admin.controller;

import com.dongsuri.admin.dto.registerDto.RegisterListResponseDto;
import com.dongsuri.admin.dto.registerDto.RegisterResponseDto;
import com.dongsuri.admin.service.RegisterService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class RegisterController {
    private final RegisterService registerService;

    @GetMapping("/registers/registerList")
    public String showRegisterListPage(Model model){
        List<RegisterListResponseDto> registerListResponseDtos = registerService.findAllDesc();
        model.addAttribute("register", registerListResponseDtos);
        return "registers/registerList";
    }

    @GetMapping("/registers/register/detail/{id}")
    public String showRegisterPage(@PathVariable Long id, Model model){
        RegisterResponseDto dto = registerService.findById(id);
        model.addAttribute("register", dto);
        return "registers/register-detail";
    }
}
