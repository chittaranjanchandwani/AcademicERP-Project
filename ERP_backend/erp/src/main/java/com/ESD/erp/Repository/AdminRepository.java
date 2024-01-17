package com.ESD.erp.Repository;

import com.ESD.erp.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository  extends JpaRepository<Admin, Integer> {
    Admin findByEmailAndPassword(String email, String password);
}
