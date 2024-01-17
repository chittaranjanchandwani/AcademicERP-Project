package com.ESD.erp.Controller;

import com.ESD.erp.Repository.DomainRepository;
import com.ESD.erp.exceptions.DomainNotFoundException;
import com.ESD.erp.model.Domains;
import com.ESD.erp.model.Students;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:3000")
public class DomainsController {
    @Autowired
    private DomainRepository domainRepository;

    @PostMapping("/domains")
    Domains newDomain(@RequestBody Domains newDomain){
        return domainRepository.save(newDomain);
    }

    @GetMapping("/domains")
    List<Domains> getAllUsers(){
        return domainRepository.findAll();
    }

    @GetMapping("/domains/{id}")
    Domains getDomainById(@PathVariable("id") Integer id) {
        return domainRepository.findById(id)
                .orElseThrow(() -> new DomainNotFoundException(id));
    }

    @PutMapping("/domains/{id}")
    Domains updateDomain(@RequestBody Domains newDomain, @PathVariable("id") Integer id) {
        return domainRepository.findById(id)
                .map(user -> {
                    user.setProgram(newDomain.getProgram());
                    user.setBatch(newDomain.getBatch());
                    user.setCapacity(newDomain.getCapacity());
                    user.setQualification(newDomain.getQualification());
                    return domainRepository.save(user);
                }).orElseThrow(() -> new DomainNotFoundException(id));
    }

    @DeleteMapping("/domains/{id}")
    String deleteUser(@PathVariable Integer id){
        if(!domainRepository.existsById(id)){
            throw new DomainNotFoundException(id);
        }
        domainRepository.deleteById(id);
        return  "Domain with id "+id+" has been deleted success.";
    }

    @GetMapping("students/{domainId}")
    List<Students> getStudentsByDomain(@PathVariable int domainId){
        return domainRepository.findStudentsByDomain(domainId);
    }
}
