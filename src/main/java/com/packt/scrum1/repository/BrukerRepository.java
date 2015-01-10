/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.packt.scrum1.repository;

/**
 *
 * @author magnussj
 */

import com.packt.scrum1.domene.Bruker;
import com.packt.scrum1.domene.Student;

public interface BrukerRepository {
    
    public boolean sqlLeggTilStudent(Student student);
    public Bruker loggInn(String brukernavn, String passord);
    
}
