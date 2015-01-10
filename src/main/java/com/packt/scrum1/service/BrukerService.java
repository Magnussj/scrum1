package com.packt.scrum1.service;

import com.packt.scrum1.domene.Bruker;
import java.util.List;
import com.packt.scrum1.domene.Student;


public interface BrukerService {
        
    public boolean sqlLeggTilStudent(Student student);
    public Bruker loggInn(String brukernavn, String passord);
    
}
