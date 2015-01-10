/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.packt.scrum1.controller;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import com.packt.scrum1.domene.ByggSetningsOppgave;
import com.packt.scrum1.domene.FlervalgsOppgave;
import com.packt.scrum1.domene.FyllInnOppgave;
import com.packt.scrum1.domene.Oppgave;
import com.packt.scrum1.domene.Spill;
import com.packt.scrum1.service.OppgaveManager;

/**
 *
 * @author Nikolas
 */
@Controller
@SessionAttributes("spillobjekt")
public class SpillKontroller {  
    
    @ModelAttribute("spillobjekt")
    public Spill lagSpill() {
        System.out.println("Nytt spillobjekt *************************    ");
        return new Spill();
    }

    @RequestMapping("spill")
    public String nesteOppgave(HttpServletRequest request, @ModelAttribute("spillobjekt") Spill spillobjekt, SessionStatus sessionStatus){
        if(spillobjekt.erFerdig()) {
            return "redirect:resultat";
        }
        if(request.getMethod().equals("GET")) {
            sessionStatus.setComplete();
            return "redirect:logginn";
        }
        
        spillobjekt.nesteOppg();
        if(spillobjekt.getGjeldendeOppgave() instanceof FlervalgsOppgave)
            return "flervalg";
        else if(spillobjekt.getGjeldendeOppgave() instanceof FyllInnOppgave)
            return "fyllinn";
        else if(spillobjekt.getGjeldendeOppgave() instanceof ByggSetningsOppgave) {
            return "byggsetning";
        }
        
        return "redirect:logginn";
    }
    
    @RequestMapping("resultat")
    public String spillFerdig(@ModelAttribute("spillobjekt") Spill spillobjekt) {
        
        return "resultat";
    }
    
    @RequestMapping("redirect")
    public String redirect(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        
        return "redirect:logginn";
    }
}
