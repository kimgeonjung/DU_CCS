package com.dongsuri.admin.service;

import com.dongsuri.admin.domain.Board;
import com.dongsuri.admin.domain.Member;
import com.dongsuri.admin.domain.User;
import com.dongsuri.admin.domain.enumFile.Role;
import com.dongsuri.admin.dto.boardDto.BoardResponseDto;
import com.dongsuri.admin.dto.memberDto.MemberListResponseDto;
import com.dongsuri.admin.dto.memberDto.MemberResponseDto;
import com.dongsuri.admin.dto.registerDto.RegisterListResponseDto;
import com.dongsuri.admin.dto.registerDto.RegisterResponseDto;
import com.dongsuri.admin.repository.MemberRepository;
import com.dongsuri.admin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    private final UserRepository userRepository;


    @Autowired
    public MemberService(MemberRepository memberRepository, UserRepository userRepository){
        this.memberRepository = memberRepository;
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public List<MemberListResponseDto> findAllDesc(){
        return memberRepository.findAllDesc().stream()
                .map(MemberListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<RegisterListResponseDto> findAllDescWithRegisterRole() {
        return memberRepository.findAllDesc().stream()
                .filter(member -> member.getUser().getRole() == Role.REGISTER) // 권한이 USER인 회원만 필터링
                .map(RegisterListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<MemberListResponseDto> findAllDescWithUserRole() {
        return memberRepository.findAllDesc().stream()
                .filter(member -> member.getUser().getRole() == Role.USER) // 권한이 USER인 회원만 필터링
                .map(MemberListResponseDto::new)
                .collect(Collectors.toList());
    }

    public RegisterResponseDto findByIdRegister (Long id){
        Member member = memberRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new RegisterResponseDto(member);
    }

    public MemberResponseDto findByIdMember (Long id){
        Member member = memberRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new MemberResponseDto(member);
    }

    public List<RegisterListResponseDto> findAllRegisterList() {
        return memberRepository.findAllDesc()
                .stream()
                .map(RegisterListResponseDto::new)
                .collect(Collectors.toList());
    }


    @Transactional
    public String acceptUser(Long member_id){
        Member member = memberRepository.findById(member_id).orElseThrow(() -> new IllegalArgumentException("해당 가입신청이 없습니다. id=" + member_id));

        if(member != null){
            User user = member.getUser();
            user.updateRole(Role.USER);
            userRepository.save(user);

            return "redirect:/members/memberList";
        }
        return "redirect:/registers/registerList";
    }

    @Transactional
    public String rejectUser(Long member_id){
        Member member = memberRepository.findById(member_id).orElseThrow(() -> new IllegalArgumentException("해당 가입신청이 없습니다. id=" + member_id));

        if(member != null) {
            User user = member.getUser();
            userRepository.delete(user);
            memberRepository.delete(member);
        }
        return "redirect:/registers/registerList";
    }
}
