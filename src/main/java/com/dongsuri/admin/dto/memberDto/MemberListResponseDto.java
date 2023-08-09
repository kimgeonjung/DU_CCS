package com.dongsuri.admin.dto.memberDto;

import com.dongsuri.admin.domain.Member;
import com.dongsuri.admin.domain.enumFile.Class_Name;
import com.dongsuri.admin.domain.enumFile.Grade;
import lombok.Getter;

@Getter
public class MemberListResponseDto {
    private Long id;
    private Grade grade;
    private Class_Name className;
    private String phone;
    private String name;

    public MemberListResponseDto(Member entity){
        this.id = entity.getMember_id();
        this.grade = entity.getRegister().getGrade();
        this.className = entity.getRegister().getClass_name();
        this.phone = entity.getRegister().getPhone();
        this.name = entity.getUser().getName();
    }
}
