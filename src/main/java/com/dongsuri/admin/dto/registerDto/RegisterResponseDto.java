package com.dongsuri.admin.dto.registerDto;

import com.dongsuri.admin.domain.Register;
import com.dongsuri.admin.domain.User;
import com.dongsuri.admin.domain.enumFile.ClassName;
import com.dongsuri.admin.domain.enumFile.Gender;
import com.dongsuri.admin.domain.enumFile.Grade;
import com.dongsuri.admin.domain.enumFile.Role;
import lombok.Getter;

@Getter
public class RegisterResponseDto {
    private String req_name;
    private Grade grade;
    private int student_num;
    private String phone;
    private ClassName class_name;
    private Gender gender;
    private String brith_date;
    private String self_introduction;
    private String motivation;
    private String desired_activity;
    private String strengths;

    private String email;
    private Role role;

    public RegisterResponseDto(Register register, User user){
        this.req_name = register.getReq_name();
        this.grade = register.getGrade();
        this.student_num = register.getStudent_num();
        this.phone = register.getPhone();
        this.class_name = register.getClass_name();
        this.gender = register.getGender();
        this.brith_date = register.getBrith_date();
        this.self_introduction = register.getSelf_introduction();
        this.motivation = register.getMotivation();
        this.desired_activity = register.getDesired_activity();
        this.strengths = register.getStrengths();

        this.email = user.getEmail();
        this.role = user.getRole();
    }
}
