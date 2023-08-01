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
public class RequestRegister extends BaseTimeEntity{
    //학년, 학번, 전화번호, 반, 성별, 생년월일
    //자기소개, 지원동기, 하고싶은_활동, 자신의_장점

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long req_id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Grade grade;

    @Column(nullable = false, unique = true)
    private int studentNum;

    @Column(nullable = false, unique = true)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ClassName className;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Gender gender;

    @Column(nullable = false)
    private String brithDate;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String selfIntroduction;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String motivation;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String desiredActivity;

    @Column(nullable = false, columnDefinition = "TEXT")
    private String strengths;

    @Builder
    public RequestRegister(Grade grade, int studentNum, String phone, ClassName className, Gender gender, String brithDate,
                           String selfIntroduction, String motivation, String desiredActivity, String strengths){
        this.grade = grade;
        this.studentNum = studentNum;
        this.phone = phone;
        this.className = className;
        this.gender = gender;
        this.brithDate = brithDate;

        this.selfIntroduction = selfIntroduction;
        this.motivation = motivation;
        this.desiredActivity = desiredActivity;
        this.strengths = strengths;
    }
}
