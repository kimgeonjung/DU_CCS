package com.dongsuri.admin.repository;

import com.dongsuri.admin.domain.Board;
import com.dongsuri.admin.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query("SELECT p FROM Member p ORDER BY p.id DESC")
    List<Member> findAllDesc();
}
