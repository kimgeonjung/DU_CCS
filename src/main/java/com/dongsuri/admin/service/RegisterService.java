package com.dongsuri.admin.service;

import com.dongsuri.admin.config.auth.dto.OAuthAttributes;
import com.dongsuri.admin.domain.Register;
import com.dongsuri.admin.domain.User;
import com.dongsuri.admin.dto.registerDto.RegisterListResponseDto;
import com.dongsuri.admin.dto.registerDto.RegisterResponseDto;
import com.dongsuri.admin.repository.RegisterRepository;
import com.dongsuri.admin.repository.UserRepository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RegisterService {
    private final RegisterRepository registerRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<RegisterListResponseDto> findAllDesc(){
        return registerRepository.findAllDesc().stream()
                .map(RegisterListResponseDto::new)
                .collect(Collectors.toList());
    }

    public RegisterResponseDto findById (Long id){
        Register register = registerRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        return new RegisterResponseDto(register);
    }

}
