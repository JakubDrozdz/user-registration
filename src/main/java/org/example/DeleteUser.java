package org.example;

import java.sql.*;
import java.util.Scanner;

public class DeleteUser {
    private static final Scanner scan = new Scanner(System.in);
    private MySqlCredentials msc;

    public DeleteUser() {
        msc = new MySqlCredentials();
    }
    public void delete(){
        DataValidation dv = new DataValidation();
        System.out.print("Enter pesel of user which you want to delete:");
        String pesel = scan.nextLine();
        while(!dv.validatePesel(pesel)){
            System.out.println("Enter correct pesel!");
            pesel = scan.nextLine();
        }
        User userToDelete = getUserData(pesel);
        deleteFromDb(pesel);
        sendConfirmation(userToDelete);
    }
    public User getUserData(String pesel){
        User user = new User();
        try (Connection conection = DriverManager.getConnection(msc.getConnectionUrl(), msc.getUsername(), msc.getPass())) {
            PreparedStatement statemnt = conection.prepareStatement("SELECT * FROM users WHERE pesel = ?");
            statemnt.setString(1,pesel);
            ResultSet rs = statemnt.executeQuery();
            rs.next();
            user.setFirstName(rs.getString("first_name"));
            user.setLastName(rs.getString("last_name"));
            user.setPesel(rs.getString("pesel"));
            user.setPostalCode(rs.getString("kod_pocztowy"));
            user.setCity(rs.getString("miasto"));
            user.setEmail(rs.getString("email"));
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(user);
        return user;
    }
    public void deleteFromDb(String pesel){
        try (Connection conection = DriverManager.getConnection(msc.getConnectionUrl(), msc.getUsername(), msc.getPass())) {
            PreparedStatement statemnt = conection.prepareStatement("DELETE FROM users WHERE pesel = ?");
            statemnt.setString(1,pesel);
            statemnt.executeUpdate();
            System.out.println("Row deleted!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void sendConfirmation(User user){
        Sender sender = new Sender();
        String subject = "User deletion confirmation";
        String content = "<h1 style=\"font-family:Arial;\">User with your email has been deleted from database!</h1>" +
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
