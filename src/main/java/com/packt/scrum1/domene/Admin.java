package com.packt.scrum1.domene;

/**
 *
 * @author magnussj
 */

public class Admin extends Bruker{
    public Admin(String fornavn, String etternavn, String epost, String beskrivelse, String passord){
        super(fornavn, etternavn, epost,"Admin", passord);
    }
    public Admin(){
        super("", "", "", "Admin", "");
    }
    
}