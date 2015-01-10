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
public class ByggSetningsOppgave extends Oppgave {
    String tekst;
    String[][] alternativer;
    String[] riktigeSvar;
    String[] svar;
    
    public ByggSetningsOppgave(String oppgavetekst, String tekst, String[][] alternativer, String[] riktigeSvar) {
        super(oppgavetekst);       
        this.tekst = tekst;
        this.alternativer = alternativer;
        this.riktigeSvar = riktigeSvar;
    }
    
    public Oppgave kopi() {
        return new ByggSetningsOppgave(oppgavetekst, tekst, alternativer, riktigeSvar);
    }
    
    public int finnPoeng() {
        int total = 0;
        for(int i = 0; i < svar.length; i++) {
            if(svar[i].equals(riktigeSvar[i]))
                total += 1;
        }
        
        return total;
    }
    
    public String[][] getAlternativer() {
        return alternativer;
    }
    
    public String getTekst() {
        return tekst;
    }
    
    public void setSvar(String[] svar) {
        this.svar = svar;
    }
    
    public String[] getSvar() {
        return svar;
    }
    
    public String toString() {
        String ret = "";
        for(int i = 0; i < svar.length; i++) {
            ret += svar[i] + '\n';
        }
        
        return ret;
    }
}
