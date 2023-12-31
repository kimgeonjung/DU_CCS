package com.dongsuri.admin.controller;


import com.dongsuri.admin.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/registers/register")
public class RegisterApiController {
    private final MemberService memberService;

    // 회원가입 수락 기능
    @PostMapping("/accept/{member_id}")
    public ResponseEntity<String> acceptRegister(@PathVariable Long member_id){
        memberService.acceptUser(member_id);
        return ResponseEntity.ok("Success");
    }

    // 회원가입 거절 기능
    @PostMapping("/reject/{member_id}")
    public ResponseEntity<String> rejectRegister(@PathVariable Long member_id){
        memberService.rejectUser(member_id);
        return ResponseEntity.ok("Success");
    }

}
