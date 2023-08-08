package com.dongsuri.admin.domain;

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

    @OneToOne
    private User user;

    @OneToOne
    private Register register;

    @Builder
    public Member(User user, Register register){
        this.user = user;
        this.register = register;
    }
}
