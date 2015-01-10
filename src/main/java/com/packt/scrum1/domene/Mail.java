package com.packt.scrum1.domene;

import java.security.SecureRandom;
import java.util.Random;
import javax.mail.Message.RecipientType;
import org.codemonkey.simplejavamail.Email;
import org.codemonkey.simplejavamail.Mailer;
import org.codemonkey.simplejavamail.TransportStrategy;

/**
 *
 * @author Endre
 */
public class Mail {
    private static final Random rnd = new SecureRandom();
    private static final int ant = 8;
    
    public static String generer(){
        String bokstaver = "abcdefghjkmnpqrstuvwxyzABCDEFGHJKMNPQRSTUVWXYZ123456789";
        String passord = "";
        for(int i = 0; i<ant; i++){
            int index = (int)(rnd.nextDouble()*bokstaver.length());
            passord += bokstaver.substring(index, index+1);
        }
        return passord;
    }
    
    public static void sendEmail(String brukernavn, String fornavn, String etternavn, String passord){
        final Email email = new Email();
        email.setFromAddress("Scrum Team 8", "scrumteam8@gmail.com");
        email.setSubject("Helt Etter Boka");
        email.addRecipient(fornavn + " " + etternavn, brukernavn, RecipientType.TO);
        email.setText("Her er passordet: " + "\n" + passord);
        new Mailer("smtp.gmail.com", 587, "scrumteam8@gmail.com", "Scrum8team", TransportStrategy.SMTP_TLS).sendMail(email);
    }
    
    
}
