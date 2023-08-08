package com.dongsuri.admin.service;

import com.dongsuri.admin.domain.Member;
import com.dongsuri.admin.domain.Register;
import com.dongsuri.admin.domain.User;
import com.dongsuri.admin.dto.memberDto.MemberListResponseDto;
import com.dongsuri.admin.repository.BoardRepository;
import com.dongsuri.admin.repository.MemberRepository;
import com.dongsuri.admin.repository.RegisterRepository;
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
    private final RegisterRepository registerRepository;
    private final BoardRepository boardRepository;


    @Autowired
    public MemberService(MemberRepository memberRepository, UserRepository userRepository,
                         RegisterRepository registerRepository, BoardRepository boardRepository){
        this.memberRepository = memberRepository;
        this.userRepository = userRepository;
        this.registerRepository = registerRepository;
        this.boardRepository = boardRepository;
    }

    @Transactional(readOnly = true)
    public List<MemberListResponseDto> findAllDesc(){
        return memberRepository.findAllDesc().stream()
                .map(MemberListResponseDto::new)
                .collect(Collectors.toList());
    }

    public void acceptUser(Long user_id, Long req_id){
        User user = userRepository.findById(user_id).orElse(null);
        Register req = registerRepository.findById(req_id).orElse(null);
        if(user != null && req != null){
            Member member = Member.builder()
                    .user(user)
                    .register(req)
                    .build();

            memberRepository.save(member);

            userRepository.delete(user);
            registerRepository.delete(req);
        }
    }

    public void rejectUser(Long user_id, Long req_id){
        User user = userRepository.findById(user_id).orElse(null);
        Register req = registerRepository.findById(req_id).orElse(null);
        if(user != null && req != null){
            userRepository.delete(user);
            registerRepository.delete(req);
        }
    }

}
