package com.dongsuri.admin.repository;

import com.dongsuri.admin.domain.Member;
import com.dongsuri.admin.domain.User;
import com.dongsuri.admin.domain.enumFile.Class_Name;
import com.dongsuri.admin.domain.enumFile.Gender;
import com.dongsuri.admin.domain.enumFile.Grade;
import com.dongsuri.admin.domain.enumFile.Role;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MemberRepositoryTest {
    @Autowired
    MemberRepository memberRepository;

    @After
    public void cleanup(){
        memberRepository.deleteAll();
    }

    @Test
    public void 회원정보_불러오기(){
        //given
        Grade grade = Grade.GRADE_1;
        Class_Name class_name = Class_Name.A_CLASS;
        Gender gender = Gender.MALE;
        String phone = "010-1234-5678";
        int student_num = 2306000;
        String brith_date = "2000-01-01";
        String self_introduction = "자기소개 테스트";
        String motivation = "지원동기 테스트";
        String desired_activity = "하고싶은활동 테스트";
        String strengths = "장점 테스트";

        memberRepository.save(Member.builder()
                        .grade(grade)
                        .class_name(class_name)
                        .gender(gender)
                        .phone(phone)
                        .student_num(student_num)
                        .brith_date(brith_date)
                        .self_introduction(self_introduction)
                        .motivation(motivation)
                        .desired_activity(desired_activity)
                        .strengths(strengths)
                .build()
        );
        //when
        List<Member> memberList = memberRepository.findAll();

        //then
        Member member = memberList.get(0);
        assertThat(member.getGrade()).isEqualTo(grade);
        assertThat(member.getClass_name()).isEqualTo(class_name);
        assertThat(member.getGender()).isEqualTo(gender);
        assertThat(member.getPhone()).isEqualTo(phone);
        assertThat(member.getStudent_num()).isEqualTo(student_num);
        assertThat(member.getBrith_date()).isEqualTo(brith_date);
        assertThat(member.getSelf_introduction()).isEqualTo(self_introduction);
        assertThat(member.getMotivation()).isEqualTo(motivation);
        assertThat(member.getDesired_activity()).isEqualTo(desired_activity);
        assertThat(member.getStrengths()).isEqualTo(strengths);
    }
}
