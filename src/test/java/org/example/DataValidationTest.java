package org.example;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DataValidationTest {
    @Test
    public void validatePostalCodeTest(){
        DataValidation dv = new DataValidation();
        assertTrue(dv.validatePostalCode("02-241"));
        assertFalse(dv.validatePostalCode("123-243"));
    }
    @Test
    public void validatePeselTest(){
        DataValidation dv = new DataValidation();
        assertTrue(dv.validatePesel("12323178901",true));
        assertFalse(dv.validatePesel("90113012358",true));
        assertFalse(dv.validatePesel("1232243",true));
    }
    @Test
    public void validateEmailTest(){
        DataValidation dv = new DataValidation();
        assertTrue(dv.validateEmail("jan.nowak@wp.pl"));
        assertFalse(dv.validateEmail("adamnowak!outlook.com"));
    }
}
