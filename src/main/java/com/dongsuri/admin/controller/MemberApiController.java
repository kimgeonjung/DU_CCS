package com.dongsuri.admin.controller;

import com.dongsuri.admin.dto.memberDto.MemberUpdateRequestDto;
import com.dongsuri.admin.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/members/member")
public class MemberApiController {
    private final MemberService memberService;

    @Autowired
    public MemberApiController(MemberService memberService) {
        this.memberService = memberService;
    }

    // 회원 정보 변경 기능
    @PutMapping("/update/{member_id}")
    public ResponseEntity<String> updateMember(@PathVariable Long member_id, @RequestBody MemberUpdateRequestDto requestDto) {
        try {
            memberService.updateMember(member_id, requestDto);
            return ResponseEntity.ok("회원 정보가 변경되었습니다.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("잘못된 요청입니다.");
        }
    }

    // 회원 권한 변경 기능
//    @PutMapping("/{member_id}/role/{role}")
//    public ResponseEntity<String> updateUserRole(@PathVariable Long member_id, @PathVariable String role){
//        try {
//            memberService.updateMemberRole(member_id, role);
//            return ResponseEntity.ok("권한이 변경되었습니다.");
//        } catch (IllegalArgumentException e){
//            return ResponseEntity.badRequest().body("잘못된 요청입니다.");
//        }
//    }
}