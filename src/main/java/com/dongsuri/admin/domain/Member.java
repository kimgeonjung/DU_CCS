package com.dongsuri.admin.domain;

import com.dongsuri.admin.domain.enumFile.ClassName;
import com.dongsuri.admin.domain.enumFile.Gender;
import com.dongsuri.admin.domain.enumFile.Grade;
import com.dongsuri.admin.domain.enumFile.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//회원 데이터베이스
@Getter
@NoArgsConstructor
@Entity
public class Member extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long member_id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String picture;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

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
    public Member(String name, String email, String picture, Role role){
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.role = role;
    }
}
