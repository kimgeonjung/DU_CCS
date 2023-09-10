package com.dongsuri.admin.dto.memberDto;

import com.dongsuri.admin.domain.enumFile.Class_Name;
import com.dongsuri.admin.domain.enumFile.Grade;
import com.dongsuri.admin.domain.enumFile.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class MemberUpdateRequestDto {
    private String id;
    private Grade grade;
    private String phone;
    private Class_Name class_name;
    private String role;

    @Builder
    MemberUpdateRequestDto(String id, Grade grade, String phone, Class_Name class_name, String role){
        this.id = id;
        this.grade = grade;
        this.phone = phone;
        this.class_name = class_name;
        this.role = role;
    }
}
