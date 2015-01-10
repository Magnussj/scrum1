package com.packt.scrum1.domene;

/**
 *
 * @author magnussj
 */

public class Veileder extends Bruker{
    public Veileder(String fornavn, String etternavn, String epost, String beskrivelse, String passord){
        super(fornavn,etternavn,epost,"Veileder", passord);
    }
    public Veileder(){
        super("", "", "", "", "");
    }
}
