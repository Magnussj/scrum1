package com.packt.scrum1.domene;

/**
 *
 * @author magnussj
 */

public abstract class Bruker {
    private String fornavn;
    private String etternavn;
    private String epost;
    private String beskrivelse;
    private String passord;
    public Bruker(){
        fornavn = "";
        etternavn = "";
        epost = "";
        beskrivelse = "";
    }
    public Bruker(String fornavn,String etternavn,String epost, String beskrivelse, String passord){
        this.fornavn = fornavn;
        this.etternavn= etternavn;
        this.epost = epost;
        this.beskrivelse = beskrivelse;
        this.passord = passord;
    }

    public String getFornavn(){
        return fornavn;
    }
    public String getEtternavn(){
        return etternavn;
    }
    public String getEpost(){
        return epost;
    }   
    
    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setFornavn(String fornavn) {
        this.fornavn = fornavn;
    }

    public void setEtternavn(String etternavn) {
        this.etternavn = etternavn;
    }

    public void setEpost(String epost) {
        this.epost = epost;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public void setPassord(String passord) {
        this.passord = passord;
    }

    public String getPassord() {
        return passord;
    }
}
