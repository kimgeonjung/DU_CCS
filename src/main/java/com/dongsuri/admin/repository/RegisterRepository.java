package com.dongsuri.admin.repository;

import com.dongsuri.admin.domain.Register;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<Register, Long> {
}
