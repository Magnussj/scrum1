/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.packt.scrum1.domene;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Nikolas
 */
public class FlervalgsOppgave extends Oppgave {
    private static final int ANT_ALTERNATIVER = 5;
    private final String[] feileSvar;
    private final String[] riktigSvar;
    private String svar;
   
    public FlervalgsOppgave(String oppgavetekst, String[] feileSvar, String[] riktigSvar) {
        super(oppgavetekst);
        this.feileSvar = feileSvar;
        this.riktigSvar = riktigSvar;
    }
       
    public ArrayList<String> getAlternativer() {
        Random r = new Random();      
        //ArrayList riktig = getRiktigSvar();   
        ArrayList<String> feil = getFeileSvar();
        ArrayList<String> alternativer = new ArrayList<String>();
        
        // Legg til ett riktig svar
        int index = r.nextInt(riktigSvar.length);
        alternativer.add(riktigSvar[index]);
        
        // Legg til feile svar
        while(alternativer.size() < ANT_ALTERNATIVER) {
            index = r.nextInt(feil.size());
            alternativer.add(feil.get(index));
            feil.remove(index);
        }
                
        // Randomiserer svarene
        Collections.shuffle(alternativer);
        
        return alternativer;
    }
    
    private ArrayList<String> getFeileSvar() {
        ArrayList<String> tmp = new ArrayList<String>();
        for(int i=0;i<feileSvar.length;i++) {
            tmp.add(feileSvar[i]);
        }
        return tmp;
    }
    
    private ArrayList<String> getRiktigSvar() {
        ArrayList<String> tmp = new ArrayList<String>();
        for(int i=0;i<riktigSvar.length;i++) {
            tmp.add(riktigSvar[i]);
        }
        return tmp;
    }
    
    public Oppgave kopi() {
        return new FlervalgsOppgave(oppgavetekst, feileSvar, riktigSvar);
    }
    
    public int finnPoeng() {
        for(int i=0;i<riktigSvar.length;i++) {
            if(riktigSvar[i].equals(svar)) {
                return 1;
            }
        }
        return 0;
    }
    
    public String getSvar() {
        return svar;
    }

    public void setSvar(String svar) {
        this.svar = svar;
    }
}