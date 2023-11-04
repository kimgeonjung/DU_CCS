package com.dongsuri.admin.service;

import com.dongsuri.admin.domain.Board;
import com.dongsuri.admin.domain.Member;
import com.dongsuri.admin.domain.User;
import com.dongsuri.admin.domain.enumFile.Role;
import com.dongsuri.admin.dto.boardDto.BoardResponseDto;
import com.dongsuri.admin.dto.boardDto.BoardUpdateRequestDto;
import com.dongsuri.admin.dto.memberDto.MemberListResponseDto;
import com.dongsuri.admin.dto.memberDto.MemberResponseDto;
import com.dongsuri.admin.dto.memberDto.MemberUpdateRequestDto;
import com.dongsuri.admin.dto.registerDto.RegisterListResponseDto;
import com.dongsuri.admin.dto.registerDto.RegisterResponseDto;
import com.dongsuri.admin.repository.BoardRepository;
import com.dongsuri.admin.repository.MemberRepository;
import com.dongsuri.admin.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;
    private final UserRepository userRepository;


    // 필터링 없이 회원 목록 출력. 현재 미사용
    @Transactional(readOnly = true)
    public List<MemberListResponseDto> findAllDesc(){
        return memberRepository.findAllDesc().stream()
                .map(MemberListResponseDto::new)
                .collect(Collectors.toList());
    }

    // 가입신청자 목록페이지. 권한이 REGISTER인 회원만 필터링
    @Transactional(readOnly = true)
    public List<RegisterListResponseDto> findAllDescWithRegisterRole() {
        return memberRepository.findAllDesc().stream()
                .filter(member -> member.getUser().getRole() == Role.REGISTER)
                .map(RegisterListResponseDto::new)
                .collect(Collectors.toList());
    }

    // 회원 목록 페이지. 권한이 USER인 회원만 필터링
    @Transactional(readOnly = true)
    public List<MemberListResponseDto> findAllDescWithUserRole() {
        return memberRepository.findAllDesc().stream()
                .filter(member -> member.getUser().getRole() == Role.USER)
                .map(MemberListResponseDto::new)
                .collect(Collectors.toList());
    }

    // 가입신청자 세부사항 페이지
    public RegisterResponseDto findByIdRegister (Long id){
        Member member = memberRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new RegisterResponseDto(member);
    }

    // 회원 세부사항 페이지
    public MemberResponseDto findByIdMember (Long id){
        Member member = memberRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new MemberResponseDto(member);
    }


    // 회원 가입 수락 기능
    @Transactional(rollbackFor = Exception.class)
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

    // 회원 가입 거절 기능
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


    // 회원 수정 기능
    @Transactional
    public Long updateMember(Long id, MemberUpdateRequestDto requestDto){
        Member member = memberRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 회원이 존재하지 않습니다. id=" + id));

        member.setGrade(requestDto.getGrade());
        member.setPhone(requestDto.getPhone());
        member.setClass_name(requestDto.getClass_name());
        Role newRole = Role.valueOf(requestDto.getRole());
        member.getUser().updateRole(newRole);
        return id;
    }

    // 회원 삭제 기능
    @Transactional
    public void delete(Long id){
        Member member = memberRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        memberRepository.delete(member);
    }

}
