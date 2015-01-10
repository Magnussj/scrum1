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
public abstract class Oppgave {
    protected final String oppgavetekst;
    
    public Oppgave(String oppgavetekst) {
        this.oppgavetekst = oppgavetekst;
    }
    
    public String getOppgavetekst() {
        return oppgavetekst;
    }
    
    public Oppgave kopi() {
        return null;
    }
    
    public int finnPoeng() {
        return -1;
    }
    
    public String toString() {
        return "";
    }
}