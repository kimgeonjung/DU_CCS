package com.dongsuri.admin.domain;

import com.dongsuri.admin.domain.enumFile.ClassName;
import com.dongsuri.admin.domain.enumFile.Gender;
import com.dongsuri.admin.domain.enumFile.Grade;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//가입신청서 데이터베이스
@Getter
@NoArgsConstructor
@Entity
public class Register extends BaseTimeEntity{
    //이름, 학년, 학번, 전화번호, 반, 성별, 생년월일
    //자기소개, 지원동기, 하고싶은_활동, 자신의_장점

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long req_id;

    @Column(nullable = false)
    private String req_name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Grade grade;

    @Column(nullable = false, unique = true)
    private int student_num;

    @Column(nullable = false, unique = true)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ClassName class_name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private String brith_date;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String self_introduction;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String motivation;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String desired_activity;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String strengths;

    @Builder
    public Register(String req_name, Grade grade, int student_num, String phone, ClassName class_name,
                    Gender gender, String brith_date, String self_introduction, String motivation,
                    String desired_activity, String strengths){
        this.req_name = req_name;
        this.grade = grade;
        this.student_num = student_num;
        this.phone = phone;
        this.class_name = class_name;
        this.gender = gender;
        this.brith_date = brith_date;

        this.self_introduction = self_introduction;
        this.motivation = motivation;
        this.desired_activity = desired_activity;
        this.strengths = strengths;
    }
}