package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidation {
    public boolean validatePesel(String pesel,boolean unique){
        Pattern pattern = Pattern.compile("^[0-9]{4}(0[1-9]|1[0-9]|2[0-9]|3[01])[0-9]{5}$");
        Matcher matcher = pattern.matcher(pesel);
        if(matcher.find()){
            PeselValidation pv = new PeselValidation();
            if(pv.getPeselList().contains(pesel) && unique){
                System.out.println("Pesel not unique!");
                return false;
            }else return true;
        }
        else {
            System.out.println("Enter correct pesel!");
            return false;
        }
    }
    public boolean validateEmail(String email){
        Pattern pattern = Pattern.compile("^(.+)@(\\S+)$");
        Matcher matcher = pattern.matcher(email);
        return matcher.find()?true:false;
    }
    public boolean validatePostalCode(String postalCode){
        Pattern pattern = Pattern.compile("^[0-9]{2}-[0-9]{3}$");
        Matcher matcher = pattern.matcher(postalCode);
        return matcher.find()?true:false;
    }
}
