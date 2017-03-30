package carnetadresses.Controllers;

import carnetadresses.Models.Contact;
import java.util.*;
import java.util.regex.*;

/**
 * 
 */
public class VerifDatas {
    
    /**
     * Verify lenght string
     * @param chaine string to test
     * @param Longueur string lenght
     * @return true if good format, false otherwise
     */
    public static boolean controlStr(String chaine, int Longueur)
    {
        return chaine == null || chaine.length() < Longueur+1;
    }
    
    /**
     * Verify tel format
     * @param tel to verify
     * @return true if good format, false otherwise
     */
    public static boolean VerifyTel(String tel) 
    {
        if(tel != null && !tel.isEmpty())
        {
            Pattern pat=Pattern.compile("^(0|\\+33)[1-9]([0-9]{2}){4}$");
            Matcher regok=pat.matcher(tel);
            if(regok.find())
            {
                 return true;
            }
            else
            {
                 return false;
            }
        }
        
        return true;
    }

    /**
     * Verify cp format
     * @param cp to verify
     * @return true if good format, false otherwise
     */
    public static boolean VerifyCP(String cp) 
    {
        if(cp != null && !cp.isEmpty())
        {
            Pattern pat=Pattern.compile("^[0-9]{5}$");
            Matcher regok=pat.matcher(cp);
            return regok.find();
        }
        
        return true;
    }
    
    /**
     * Verify email format
     * @param email to verify
     * @return true if good format, false otherwise
     */
    public static boolean VeriofyEmail(String email)
    {
        if(email != null && !email.isEmpty())
        {
            Pattern pat=Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
            Matcher regok=pat.matcher(email);
            return regok.find();
        }
        
        return true;
    }
}