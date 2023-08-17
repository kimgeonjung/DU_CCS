package com.dongsuri.admin.dto.memberDto;

import com.dongsuri.admin.domain.Member;
import com.dongsuri.admin.domain.enumFile.Class_Name;
import com.dongsuri.admin.domain.enumFile.Gender;
import com.dongsuri.admin.domain.enumFile.Grade;

import com.dongsuri.admin.domain.enumFile.Role;
import lombok.Getter;

@Getter
public class MemberResponseDto {
    private String name;
    private String email;
    private Grade grade;
    private int student_num;
    private String phone;
    private Class_Name class_name;
    private Gender gender;
    private String brith_date;
    private String self_introduction;
    private String motivation;
    private String desired_activity;
    private String strengths;
    private Role role;

    public MemberResponseDto(Member entity){
        this.name = entity.getUser().getName();
        this.email = entity.getUser().getEmail();
        this.grade = entity.getGrade();
        this.student_num = entity.getStudent_num();
        this.phone = entity.getPhone();
        this.class_name = entity.getClass_name();
        this.gender = entity.getGender();
        this.brith_date = entity.getBrith_date();
        this.self_introduction = entity.getSelf_introduction();
        this.motivation = entity.getMotivation();
        this.desired_activity = entity.getDesired_activity();
        this.strengths = entity.getStrengths();
        this.role = entity.getUser().getRole();
    }
}
