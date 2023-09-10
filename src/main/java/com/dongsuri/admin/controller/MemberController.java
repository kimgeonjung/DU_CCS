package com.dongsuri.admin.controller;

import com.dongsuri.admin.dto.boardDto.BoardResponseDto;
import com.dongsuri.admin.dto.memberDto.MemberListResponseDto;
import com.dongsuri.admin.dto.memberDto.MemberResponseDto;
import com.dongsuri.admin.dto.registerDto.RegisterListResponseDto;
import com.dongsuri.admin.dto.registerDto.RegisterResponseDto;
import com.dongsuri.admin.service.MemberService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/members/memberList")
    public String showMemberListPage(Model model){
        List<MemberListResponseDto> memberListResponseDto = memberService.findAllDescWithUserRole();
        model.addAttribute("member", memberListResponseDto);
        return "members/memberList";
    }

    @GetMapping("/members/member/detail/{id}")
    public String showMemberPage(@PathVariable Long id, Model model){
        MemberResponseDto memberResponseDto = memberService.findByIdMember(id);
        model.addAttribute("member", memberResponseDto);
        return "members/member-detail";
    }

    @GetMapping("/members/member/update/{id}")
    public String memberUpdate(@PathVariable Long id, Model model){
        MemberResponseDto memberResponseDto = memberService.findByIdMember(id);
        model.addAttribute("member", memberResponseDto);

        return "/members/member-update";
    }

}

