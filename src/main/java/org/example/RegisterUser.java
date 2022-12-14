package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class RegisterUser {
    private static final Scanner scan = new Scanner(System.in);
    private MySqlCredentials msc;

    public RegisterUser() {
        msc = new MySqlCredentials();
    }

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
            postalCode = scan.nextLine();
        }
        System.out.print("Enter pesel:");
        String pesel = scan.nextLine();
        while(!dv.validatePesel(pesel,true)){
            pesel = scan.nextLine();
        }
        System.out.print("Enter e-mail:");
        String email = scan.nextLine();
        while(!dv.validateEmail(email)){
            System.out.println("Enter correct e-mail!");
            email = scan.nextLine();
        }

        User newUser = new User(firstName,lastName,pesel,postalCode,city,email);
        saveToDb(newUser);
        sendConfirmation(newUser);
    }

    private void saveToDb(User user){
        try (Connection conection = DriverManager.getConnection(msc.getConnectionUrl(), msc.getUsername(), msc.getPass())) {
            String statemnt = "INSERT INTO users VALUES(null," +
                    "'"+user.getFirstName()+"'," +
                    "'"+user.getLastName()+"'," +
                    "'"+user.getPesel()+"'," +
                    "'"+user.getPostalCode()+"'," +
                    "'"+user.getCity()+"'," +
                    "'"+user.getEmail()+"')";
            Statement stmt = conection.createStatement();
            stmt.executeUpdate(statemnt);
            System.out.println("Row inserted!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    private void sendConfirmation(User user){
        Sender sender = new Sender();
        String subject = "User registration confirmation";
        String content = "<h1 style=\"font-family:Arial;\">User with your email has been added to database!</h1>" +
                "<h2 style=\"font-family:Arial;\">Details:</h2>" +
                "<ul style=\"font-family:Arial;list-style:none\">" +
                "<li>First name: "+user.getFirstName()+"</li>" +
                "<li>Last name: "+user.getLastName()+"</li>" +
                "<li>PESEL: "+user.getPesel()+"</li>" +
                "<li>Postal code: "+user.getPostalCode()+"</li>" +
                "<li>City: "+user.getCity()+"</li>" +
                "<li>E-mail address: "+user.getEmail()+"</li>" +
                "</ul>";
        sender.send(user.getEmail(),content,subject);
    }
}
