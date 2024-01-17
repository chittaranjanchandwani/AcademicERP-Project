package com.ESD.erp.Repository;

import com.ESD.erp.model.Domains;
import com.ESD.erp.model.Students;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DomainRepository extends JpaRepository<Domains,Integer> {

    @Query("SELECT d.students FROM Domains d WHERE d.domain_id =:domainId")
    List<Students> findStudentsByDomain(int domainId);
}

