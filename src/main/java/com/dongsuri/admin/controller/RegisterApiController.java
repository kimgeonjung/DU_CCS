package com.dongsuri.admin.controller;


import com.dongsuri.admin.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/registers/register")
public class RegisterApiController {
    private final MemberService memberService;

    @Autowired
    public RegisterApiController(MemberService memberService){
        this.memberService = memberService;
    }

    @PostMapping("/accept/{member_id}")
    public ResponseEntity<String> acceptRegister(@PathVariable Long member_id){
        memberService.acceptUser(member_id);
        return ResponseEntity.ok("Success");
    }

    @PostMapping("/reject/{member_id}")
    public ResponseEntity<String> rejectRegister(@PathVariable Long member_id){
        memberService.rejectUser(member_id);
        return ResponseEntity.ok("Success");
    }
}
