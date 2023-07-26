package com.dongsuri.admin.repository;

import com.dongsuri.admin.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
