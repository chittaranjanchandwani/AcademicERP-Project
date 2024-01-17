package com.ESD.erp.Repository;

import com.ESD.erp.model.Domains;
import com.ESD.erp.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentsRepository extends JpaRepository<Students, Integer> {

}
