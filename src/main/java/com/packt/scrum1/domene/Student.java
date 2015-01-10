package com.packt.scrum1.domene;

/**
 *
 * @author magnussj
 */

public class Student extends Bruker{
    public Student(String fornavn, String etternavn, String epost, String beskrivelse, String passord){
        super(fornavn,etternavn,epost,"Student", passord);
    }
    public Student(){
        super("","","","Student", "");
    }
    
}
