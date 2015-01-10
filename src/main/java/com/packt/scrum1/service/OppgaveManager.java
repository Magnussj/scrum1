/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.packt.scrum1.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import com.packt.scrum1.domene.ByggSetningsOppgave;
import com.packt.scrum1.domene.FlervalgsOppgave;
import com.packt.scrum1.domene.FyllInnOppgave;
import com.packt.scrum1.domene.Oppgave;

public class OppgaveManager {
    public static final ArrayList<Oppgave> alleOppgaver;
    
    static {
        alleOppgaver = new ArrayList<Oppgave>();
        alleOppgaver.add(new FlervalgsOppgave("Du skal vise frem et bilde på nettsiden din. Hvilken av disse taggene vil du bruke?",
                                                            new String[] {"&ltbld src = “bilde.jpg”/&gt", "&ltpic src = “bilde.jpg”/&gt", "&ltimage src = “bilde.jpg”/&gt", "&ltjpg src = “bilde.jpg”/&gt"}, new String[] {"&ltimg src = “bilde.jpg”/&gt"}));
        
        
        alleOppgaver.add(new FlervalgsOppgave("CSS baserer seg på en kjent modell, som gjør det enkelt å organisere de ulike delene av en nettside. Hva heter denne modellen?", 
                                                            new String[] {"Hjørnemodellen", "Firkantmodellen", "Kantmodellen", "Sidemodellen"}, new String[] {"Boksmodellen"}));
        alleOppgaver.add(new FlervalgsOppgave("Hva definerer et markeringsspråk?", 
                                                            new String[] {"Språk som benytter tagger", "Språk som kompileres til prosessorinstruksjoner", "Språk som tolkes og leses som en del av utførelsen", "Språk som bruker klasser"}, new String[] {"Språk som håndterer tekst i tillegg til tekstens struktur og oppsett"}));

        alleOppgaver.add(new ByggSetningsOppgave("Tekst:", "HTML er __________ dvs. lenker som gjør at vi kan hoppe fra dokument til dokument med et enkelt klikk. Vi får da ___________ av dokumenter koblet sammen. \n" +
                                                    "HTML er også et ___________. Vi koder ved å markere innholdet etter hvordan det skal vises. Dette gjøres med ___________.", 
                                                    new String[][] {{"hypertekst", "supertekst", "ultratekst"}, 
                                                                    {"et dokument", "en database", "et nettverk"}, 
                                                                    {"Objektorientert språk", "Markeringsspråk", "Koblingsspråk"}, 
                                                                    {"Klasser", "Tagger", "Metoder"}}, new String[] {"hypertekst", "et nettverk", "Markeringsspråk", "Tagger"}));

        alleOppgaver.add(new FyllInnOppgave("Beskrivelse", new String[] {"CSS står for: ", ""}, new String[] {"Cascading Style Sheets"}));
    }
    
    public static ArrayList<Oppgave> getAlleOppgaver() {
        return alleOppgaver;
    }
}
