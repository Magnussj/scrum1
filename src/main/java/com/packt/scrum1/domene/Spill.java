/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.packt.scrum1.domene;

import java.util.ArrayList;
import java.util.Random;
import com.packt.scrum1.service.OppgaveManager;

public class Spill {
    public static final int ANT_OPPGAVER = 5;
    
    Oppgave[] oppgaver;
    int gjeldendeOppgaveIndex;
    Oppgave gjeldendeOppgave;

    public Spill() {
        genererSpill();
    }
    
    public void genererSpill() {
        ArrayList<Oppgave> alleOppgaver = new ArrayList<Oppgave>();
        
        ArrayList<Oppgave> liste = OppgaveManager.getAlleOppgaver();
        for(int i = 0; i < liste.size(); i++) {
            alleOppgaver.add(liste.get(i));
        }
        
        Random r = new Random();
        oppgaver = new Oppgave[ANT_OPPGAVER];
        for(int i = 0; i < ANT_OPPGAVER; i++) {
            int tall = r.nextInt(alleOppgaver.size());
            oppgaver[i] = alleOppgaver.get(tall).kopi();
            alleOppgaver.remove(tall);
        }
        
        gjeldendeOppgaveIndex = 0;
    }
    
    public void nesteOppg() {
        gjeldendeOppgave = oppgaver[gjeldendeOppgaveIndex++];
    }

    public boolean erFerdig() {
        if(gjeldendeOppgaveIndex == ANT_OPPGAVER) {
            
            return true;
        }
        
        return false;
    }
    
    public Oppgave getGjeldendeOppgave() {
        return gjeldendeOppgave;
    }
    
    public Oppgave[] getOppgaver() {
        return oppgaver;
    }
    
    public int getTotalPoeng() {
        int total = 0;
        for(int i = 0; i < oppgaver.length; i++) {
            total += oppgaver[i].finnPoeng();
        }
        
        return total;
    }
}