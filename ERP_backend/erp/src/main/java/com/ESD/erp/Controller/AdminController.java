package com.ESD.erp.Controller;

import com.ESD.erp.Repository.AdminRepository;
import com.ESD.erp.Repository.DomainRepository;
import com.ESD.erp.model.Admin;
import com.ESD.erp.model.Domains;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:3000")
public class AdminController {
    @Autowired
    private AdminRepository adminRepository;



    @PostMapping("/admin")
    Admin newAdmin(@RequestBody Admin newAdmin){
        return adminRepository.save(newAdmin);
    }

        @PostMapping("/login")
    public ResponseEntity<Admin> login(@RequestBody Admin admin) {
        Admin loggedInAdmin = adminRepository.findByEmailAndPassword(admin.getEmail(), admin.getPassword());

        if (loggedInAdmin == null)
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        else
            return ResponseEntity.ok().body(loggedInAdmin);
    }

}


