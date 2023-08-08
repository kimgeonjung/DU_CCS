package com.dongsuri.admin.controller;

import com.dongsuri.admin.dto.memberDto.MemberListResponseDto;
import com.dongsuri.admin.service.MemberService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/members/memberList")
    public String showMemberListPage(Model model){
        List<MemberListResponseDto> memberListResponseDto = memberService.findAllDesc();
        model.addAttribute("member", memberListResponseDto);
        return "members/memberList";
    }
}
