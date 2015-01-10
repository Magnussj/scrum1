/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.packt.scrum1.domene;

/**
 *
 * @author Nikolas
 */
public class FyllInnOppgave extends Oppgave {
    private final String[] tekst;
    private final String[] losning;
    private String[] svar;
    
    public FyllInnOppgave(String oppgavetekst, String[] tekst, String[] losning) {
        super(oppgavetekst);
        this.tekst = tekst;
        this.losning = losning;
        svar = new String[losning.length];
    }
    
    public String[] getSvar() {
        return svar;
    }
    
    public void setSvar(String[] svar) {
        this.svar = svar;
    }
    
    public String[] getTekst() {
        return tekst;
    }
    
    public Oppgave kopi() {
        return new FyllInnOppgave(oppgavetekst, tekst, losning);
    }
    
    public int finnPoeng() {
        int poeng = 0;
        for(int i=0;i<losning.length;i++) {
            if(losning[i].toLowerCase().equals(svar[i].toLowerCase())) {
                poeng++;
            }
        }
        return poeng;
    }
}
