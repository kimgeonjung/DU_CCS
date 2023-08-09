package com.dongsuri.admin.repository;

import com.dongsuri.admin.domain.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RegisterRepository extends JpaRepository<Register, Long> {
    @Query("SELECT p FROM Register p ORDER BY p.id DESC")
    List<Register> findAllDesc();
}
