package com.dongsuri.admin.service;

import com.dongsuri.admin.domain.Member;
import com.dongsuri.admin.domain.User;
import com.dongsuri.admin.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
    private final MemberRepository memberRepository;


    @Autowired
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

//    public void acceptUser(Long user_id){
//        User user = userRepository.findById(user_id).orElse(null);
//        if(user != null){
//            Member member = Member.builder()
//                    .name(user.getName())
//                    .email(user.getEmail())
//                    .picture(user.getPicture())
//                    .role(user.getRole())
//                    .build();
//
//            memberRepository.save(member);
//
//            userRepository.delete(user);
//        }
//    }
//
//    public void rejectUser(Long user_id){
//        userRepository.deleteById(user_id);
//    }

}
