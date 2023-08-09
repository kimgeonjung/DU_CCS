package com.dongsuri.admin.controller;


import com.dongsuri.admin.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@RestController
@RequestMapping("api/v1/registers/register")
public class RegisterApiController {
    private final MemberService memberService;

    @Autowired
    public RegisterApiController(MemberService memberService){
        this.memberService = memberService;
    }

    @PostMapping("/accept/{user_id}/{register_id}")
    public ResponseEntity<String> acceptRegister(@PathVariable Long user_id, @PathVariable Long register_id){
        memberService.acceptUser(user_id, register_id);
        return ResponseEntity.ok("Success");
    }

    @PostMapping("/reject/{user_id}/{register_id}")
    public ResponseEntity<String> rejectRegister(@PathVariable Long user_id, @PathVariable Long register_id){
        memberService.rejectUser(user_id, register_id);
        return ResponseEntity.ok("Success");
    }
}
