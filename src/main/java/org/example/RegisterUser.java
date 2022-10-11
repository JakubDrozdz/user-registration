package org.example;

import java.util.Scanner;

public class RegisterUser {
    private static final Scanner scan = new Scanner(System.in);
    public void register(){
        DataValidation dv = new DataValidation();
        System.out.print("Enter first name:");
        String firstName = scan.nextLine();
        System.out.print("Enter last name:");
        String lastName = scan.nextLine();
        System.out.print("Enter city:");
        String city = scan.nextLine();
        System.out.print("Enter postal code:");
        String postalCode = scan.nextLine();
        while(!dv.validatePostalCode(postalCode)){
            System.out.println("Enter correct postal code!");
        }
        System.out.print("Enter pesel:");
        String pesel = scan.nextLine();
        while(!dv.validatePesel(pesel)){
            System.out.println("Enter correct pesel!");
        }
        System.out.print("Enter e-mail:");
        String email = scan.nextLine();
        while(!dv.validateEmail(email)){
            System.out.println("Enter correct e-mail!");
        }
    }
}
