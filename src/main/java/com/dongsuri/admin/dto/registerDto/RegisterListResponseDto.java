package com.dongsuri.admin.dto.registerDto;
import com.dongsuri.admin.domain.Register;
import com.dongsuri.admin.domain.enumFile.Grade;
import java.time.LocalDateTime;

import lombok.Getter;

@Getter
public class RegisterListResponseDto {
    private Long id;
    private Grade grade;
    private int student_num;
    private String req_name;
    private LocalDateTime modifiedDate;

    public RegisterListResponseDto(Register entity){
        this.id = entity.getReq_id();
        this.grade = entity.getGrade();
        this.student_num = entity.getStudent_num();
        this.req_name = entity.getReq_name();
        this.modifiedDate = entity.getModifiedDate();
    }
}
