package com.dongsuri.admin.domain;

import com.dongsuri.admin.domain.enumFile.Class_Name;
import com.dongsuri.admin.domain.enumFile.Gender;
import com.dongsuri.admin.domain.enumFile.Grade;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

//회원 데이터베이스
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Member extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_id;

    @OneToOne
    private User user;

    //학년, 학번, 전화번호, 반, 성별, 생년월일
    //자기소개, 지원동기, 하고싶은_활동, 자신의_장점

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Grade grade;

    @Column(nullable = false, unique = true)
    private int student_num;

    @Column(nullable = false, unique = true)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Class_Name class_name;

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
    public Member(User user, Grade grade, int student_num, String phone, Class_Name class_name,
                  Gender gender, String brith_date, String self_introduction, String motivation,
                  String desired_activity, String strengths){
        this.user = user;
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
