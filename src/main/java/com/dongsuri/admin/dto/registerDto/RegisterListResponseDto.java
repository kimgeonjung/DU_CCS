package com.dongsuri.admin.dto.registerDto;
import com.dongsuri.admin.domain.Member;
import com.dongsuri.admin.domain.enumFile.Class_Name;
import com.dongsuri.admin.domain.enumFile.Grade;
import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class RegisterListResponseDto {
    private Long id;
    private Grade grade;
    private int student_num;
    private String name;
    private String email;
    private LocalDateTime modifiedDate;
    private Class_Name class_name;

    public RegisterListResponseDto(Member entity){
        this.id = entity.getMember_id();
        this.grade = entity.getGrade();
        this.student_num = entity.getStudent_num();
        this.name = entity.getUser().getName();
        this.email = entity.getUser().getEmail();
        this.modifiedDate = entity.getModifiedDate();
        this.class_name = entity.getClass_name();
    }
}
