package com.dongsuri.admin.controller;

import com.dongsuri.admin.dto.boardDto.BoardUpdateRequestDto;
import com.dongsuri.admin.dto.memberDto.MemberUpdateRequestDto;
import com.dongsuri.admin.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/member")
public class MemberApiController {
    private final MemberService memberService;

    // 회원 정보 변경 기능
    @PutMapping("/{id}")
    public Long updateMember(@PathVariable Long id, @RequestBody MemberUpdateRequestDto requestDto) {
        return memberService.updateMember(id, requestDto);
    }

    // 회원 삭제 기능
    @DeleteMapping("/{id}")
    public Long deleteMember(@PathVariable Long id){
        memberService.delete(id);
        return id;
    }
}
