package com.dongsuri.admin.service;

import com.dongsuri.admin.domain.Member;
import com.dongsuri.admin.domain.User;
import com.dongsuri.admin.repository.MemberRepository;
import com.dongsuri.admin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final MemberRepository memberRepository;

    @Autowired
    public UserService(UserRepository userRepository, MemberRepository memberRepository){
        this.userRepository = userRepository;
        this.memberRepository = memberRepository;
    }

    public void acceptUser(Long user_id){
        User user = userRepository.findById(user_id).orElse(null);
        if(user != null){
            Member member = Member.builder()
                    .name(user.getName())
                    .email(user.getEmail())
                    .picture(user.getPicture())
                    .role(user.getRole())
                    .build();

            memberRepository.save(member);

            userRepository.delete(user);
        }
    }

    public void rejectUser(Long user_id){
        userRepository.deleteById(user_id);
    }

    public User getUserByEmail(String email){
        return userRepository.findByEmail(email).orElse(null);
    }

    public List<User> getAllMembers(){
        return userRepository.findAll();
    }
}
