package com.dongsuri.admin.controller;

import com.dongsuri.admin.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/member")
public class MemberApiController {
    private final MemberService memberService;

    @Autowired
    public MemberApiController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/accept/{userId}/{reqId}")
    public ResponseEntity<String> acceptMembership(@PathVariable Long userId, @PathVariable Long reqId) {
        memberService.acceptUser(userId, reqId);
        return ResponseEntity.ok("Membership accepted");
    }

    @PostMapping("/reject/{userId}/{reqId}")
    public ResponseEntity<String> rejectMembership(@PathVariable Long userId, @PathVariable Long reqId) {
        memberService.rejectUser(userId, reqId);
        return ResponseEntity.ok("Membership rejected");
    }
}