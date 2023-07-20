package com.dongsuri.admin.repository;

import com.dongsuri.admin.domain.UserEntity;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountRepositoryTest {
    @Autowired
    AccountRepository accountRepository;

    @After
    public void cleanup(){
        accountRepository.deleteAll();
    }

    @Test
    public void 계정정보_불러오기(){
        //given
        String name = "테스트 이름";
        String email = "테스트 이메일";

        accountRepository.save(UserEntity.builder()
                .name(name)
                .email(email)
                .build());

        //when
        List<UserEntity> userEntityList = accountRepository.findAll();

        //then
        UserEntity account = userEntityList.get(0);
        assertThat(account.getName()).isEqualTo(name);
        assertThat(account.getEmail()).isEqualTo(email);
    }
}
