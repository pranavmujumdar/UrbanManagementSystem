/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Validation;

import Business.UserAccount.UserAccount;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Hardik
 */
public class Validation {

    public static boolean checkEmpty(String value) {

        if (value.isEmpty()) {
            return true;
        }
        return false;
    }
    
    public static boolean regexMedicineQty(String number) {
        String regexNumber = "^[0-9]{1,3}$";
        if (number.matches(regexNumber)) {
            return true;
        }
        // JOptionPane.showMessageDialog(null, "Please enter the field in Number only");
        return false;
    }

    public static boolean regexTextCheck(String text) {
        String regexText = "[a-zA-Z]+";
        if (text.matches(regexText)) {
            return true;
        }

        return false;
    }
    
    public static boolean regexMedicineName(String user) {
        String regexUser = "^[a-zA-Z0-9]{1,}$";
        if (user.matches(regexUser)) {
            return true;
        }
        //JOptionPane.showMessageDialog(null, "Please enter the field correctly");
        return false;
    }
    
     public static boolean regexMedicine(String user) {
        String regexUser = "^[a-zA-Z0-9]{1,3}$";
        if (user.matches(regexUser)) {
            return true;
        }
        //JOptionPane.showMessageDialog(null, "Please enter the field correctly");
        return false;
    }

    public static boolean regexAgeCheck(String number) {
        String regexNumber = "[0-9]+";
        if (number.matches(regexNumber)) {
            return true;
        }
        // JOptionPane.showMessageDialog(null, "Please enter the field in Number only");
        return false;
    }

    public static boolean regexUser(String user) {
        String regexUser = "^[a-zA-Z0-9]{6,}$";
        if (user.matches(regexUser)) {
            return true;
        }
        //JOptionPane.showMessageDialog(null, "Please enter the field correctly");
        return false;
    }
    
    public static boolean textAndSpace(String text)
    {
        String regex = "^[^\\s][a-zA-Z\\s]*$";
        if(text.matches(regex))
        {
            return true;
        }
        return false;
    }
    
    public static boolean userNameWithUnderscoreDotNumbers(String str)
    {
        Pattern p = Pattern.compile("^[A-Za-z][A-Za-z0-9]*(?:_[A-Za-z0-9]+)*(?:.[A-Za-z0-9]+)*$");
        Matcher m = p.matcher(str);
        boolean b = m.matches();
        //if(b && nameJTextField.getText().length()>4)
        
            return b;
        
        
    }
    
    public static boolean ssnCheck(String str)
    {
        Pattern p = Pattern.compile("^[0-9]{9}$");
        Matcher m = p.matcher(str);
        boolean b = m.matches();
        //if(b && nameJTextField.getText().length()>4)
        
            return b;
    }

    public static boolean phoneNumberCheck(String str)
    {
        Pattern p = Pattern.compile("^[0-9]{10}$");
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
    
    public static boolean isNumber(String str)
    {
        Pattern p = Pattern.compile("^[0-9]+$");;
        Matcher m = p.matcher(str);
        boolean b = m.matches();
        return b;
        
        //return false;
    }
    
    public static boolean isAlphaNumeric(String str)
    {
        Pattern p = Pattern.compile("^[a-bA-B0-9]+$");
        Matcher m = p.matcher(str);
        boolean b = m.matches();
        return b;
    }
    
    public static boolean isInt(String str)
    {
        Pattern p = Pattern.compile("^[0-9]{1,4}$");;
        Matcher m = p.matcher(str);
        boolean b = m.matches();
        return b;
        
        //return false;
    }

}
