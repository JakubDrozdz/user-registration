package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidation {
    public boolean validatePesel(String pesel){
        Pattern pattern = Pattern.compile("^[0-9]{11}$");
        Matcher matcher = pattern.matcher(pesel);
        return matcher.find()?true:false;
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
