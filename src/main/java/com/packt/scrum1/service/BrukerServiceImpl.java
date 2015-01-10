package com.packt.scrum1.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.packt.scrum1.domene.Bruker;
import com.packt.scrum1.domene.Student;
import com.packt.scrum1.repository.BrukerRepository;

//@Service
public class BrukerServiceImpl implements BrukerService{
     
    private BrukerRepository repo;

     @Autowired
     public void setRepository(BrukerRepository repo){
         System.out.println("BrukerServiceImpl.setDatabase2   " + repo);
         this.repo = repo;
     }
    
    public boolean sqlLeggTilStudent(Student student){
        System.out.println("**** BrukerServiceImpl.registrerBruker()  *** ");
        return repo.sqlLeggTilStudent(student);
    }
    
    public Bruker loggInn(String brukernavn, String passord){
        return repo.loggInn(brukernavn, passord);
    }
}
