package com.packt.scrum1.controller;

/**
 *
 * @author magnussj
 */
import com.packt.scrum1.domene.Bruker;
import com.packt.scrum1.domene.Student;
import com.packt.scrum1.service.BrukerService;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InnloggingController {
    
    @Autowired
    private BrukerService brukerService;
    
    @ModelAttribute("bruker")
    public Student sqlLeggTilStudent() {
        return new Student();
    }

    @RequestMapping("/")
    public String redirect(){
	return "innlogging";
    }
        
    @RequestMapping(value="regny")
    public String nybruker() {
        
        return "nybruker";
    }
    
    @RequestMapping(value="tilbake")
    public String tilbake() {
        return "innlogging";
    }
    
    
    
    
    //Sørger for å gi en feilside når feil oppstår, merk at vi godt kunne hatt
    //flere slike feilhåndterere og håndtert ulike feil mer spesifikt
    //Denne metoden håndterer og "SQL-exceptions" (bortsett fra DuplicateKeyException)
    //om vi bruker PersonDatabaseJdbcTemplateRepositoryImpl som repository i stedet for 
    //PersonDatabaseRepositoryImpl. Dette avgjøres i springmvc.konfig.Konfigurasjon.respoistory().
    @ExceptionHandler({Exception.class})
    public ModelAndView handleError(HttpServletRequest req, Exception exception) {
        System.out.println("Feil i NyPersonKontroller.handleError " + exception);
        
        ModelAndView mav = new ModelAndView();
        mav.addObject("melding", "feilmelding.generell");
        mav.addObject("unntak", exception);
        mav.setViewName("nybruker");
        return mav;
    }
    
    //Håndterer "SQL"-unntaket DuplicateKeyException
    @ExceptionHandler({DuplicateKeyException.class})
    public ModelAndView handleDuplicateKey(HttpServletRequest req, Exception exception) {
        System.out.println("Feil i NyPersonKontroller.handleError " + exception);
        
        ModelAndView mav = new ModelAndView();
        //mav.addObject("melding", "To personer kan ikke ha samme personnr");
        mav.addObject("melding", "feilmelding.prim.nokkel");
        mav.addObject("unntak", exception);
        mav.setViewName("nybruker");
        return mav;
    }
    
       
    @RequestMapping(value = "reg" , method=RequestMethod.GET)
    public String student(@ModelAttribute("student") Student student) {
        System.out.println(" ******   NyPerson.controller.person() ");
        return "nybruker";
    }

    @RequestMapping(value = "reg" , method=RequestMethod.POST)
    public String svarside(@Valid @ModelAttribute("bruker") Student student, BindingResult error, Model modell) {
        
        if(error.hasErrors()){
            System.out.println(" Validering feilet **** ");
            //modell.addAttribute("melding", "Personnr ikke fylt ut riktig"); // kun ibruk v return svarside
            return "nybruker";
        }
        
        System.out.println(" **** Bruker verdi i nybrukercontroller " + student);
        
        if (brukerService.sqlLeggTilStudent(student)) {
            modell.addAttribute("melding","Bruker " + student + " er registrert");
            return "innlogging";
        } else {
            modell.addAttribute("melding","feilmelding.reg.person");//DENNE LINJEN ER ENDRET SIDEN VIDEO BLE LAGET
            return "spill";
        }
    }
    
    @RequestMapping(value = "logginn" , method=RequestMethod.GET)
    public String heisann(@ModelAttribute("student") Student student) {
        System.out.println(" ******   NyPerson.controller.person() ");
        return "innlogging";
    }

    @RequestMapping(value = "logginn" , method=RequestMethod.POST)
    public String velkommen(@Valid @ModelAttribute("bruker") Bruker bruker, BindingResult error, Model modell) {
        
        if(error.hasErrors()){
            System.out.println(" Validering feilet **** ");
            return "innlogging";
        }
        
        System.out.println(" **** Bruker verdi i nybrukercontroller " + bruker);
        
        if (brukerService.loggInn(bruker.getEpost(), bruker.getPassord()).getEpost().equals(bruker.getEpost())) {
            modell.addAttribute("melding","Bruker: " + bruker.getEpost() + " er logget inn");
            return "hovedside";
        } else {
            modell.addAttribute("melding","feilmelding.reg.person");//DENNE LINJEN ER ENDRET SIDEN VIDEO BLE LAGET
            return "nybruker";
        }
    }
}
