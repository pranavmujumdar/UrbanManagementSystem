/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author joaey
 */
public class Validate {
    
    //String str;
     public static boolean locationPatternCorrect(String str)
    {
        //Pattern p = Pattern.compile("^[a-zA-Z0-9\\s]{2,}[^\\s$]");
        Pattern p = Pattern.compile("^[-a-zA-Z0-9-()]+(\\s+[-a-zA-Z0-9-()]+)*$");
        
        Matcher m = p.matcher(str);
        boolean b = m.matches();
        //if(b && nameJTextField.getText().length()>4)
        
            return b;
    }
    
    public static boolean landmarkPatternCorrect(String str)
    {
        //Pattern p = Pattern.compile("^[a-zA-Z0-9\\s]{2,}[^\\s$]");
        Pattern p = Pattern.compile("^[-a-zA-Z0-9-()]+(\\s+[-a-zA-Z0-9-()]+)*$");
        Matcher m = p.matcher(str);
        boolean b = m.matches();
        //if(b && nameJTextField.getText().length()>4)
        
            return b;
    }
    public static boolean quantityPatternCorrect(String str)
    {
        Pattern p = Pattern.compile("^(0|[1-9][0-9]{1,9})$");
        Matcher m = p.matcher(str);
        boolean b = m.matches();
        //if(b && nameJTextField.getText().length()>4)
        
            return b;
    }
    //^(0|[1-9][0-9]{1,9})$  --either 0 or non-zero numbers till 9 digits
    public static boolean contactPatternCorrect(String str)
    {
        Pattern p = Pattern.compile("^^[1-9][0-9]{9}$");
        Matcher m = p.matcher(str);
        boolean b = m.matches();
        //if(b && nameJTextField.getText().length()>4)
        
            return b;
    }
    
    public static boolean ssnPatternCorrect(String str)
    {
        Pattern p = Pattern.compile("^[1-9][0-9]{8}$");
        Matcher m = p.matcher(str);
        boolean b = m.matches();
        //if(b && nameJTextField.getText().length()>4)
        
            return b;
    }
    public static boolean numberPatternCorrect(String str)
    {
        Pattern p = Pattern.compile("^(0|[1-9][0-9]{8,8})$");
        Matcher m = p.matcher(str);
        boolean b = m.matches();
        //if(b && nameJTextField.getText().length()>4)
        
            return b;
    }
    //^(0|[1-9][0-9]{1,9})$  ----for number of digits between 1-9
    public static boolean namePatternCorrect(String str)
    {
        Pattern p = Pattern.compile("^[a-zA-Z]{2,}");
        Matcher m = p.matcher(str);
        boolean b = m.matches();
        //if(b && nameJTextField.getText().length()>4)
        
            return b;
        
        
    }
    
    public static boolean usernamePatternCorrect(String str)
    {
        Pattern p = Pattern.compile("^[a-zA-Z0-9]{4,}");
        Matcher m = p.matcher(str);
        boolean b = m.matches();
        //if(b && nameJTextField.getText().length()>4)
        
            return b;
        
        
    }
    
    public static boolean passwordPatternCorrect(String str)
    {
        Pattern p = Pattern.compile("^(?=.{5,})(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$");
        Matcher m = p.matcher(str);
        boolean b = m.matches();
        return b;
        
        //return false;
    }
    
    
    
}
