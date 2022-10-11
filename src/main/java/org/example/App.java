package org.example;

import java.util.Scanner;

public class App 
{
    private static final Scanner scan = new Scanner(System.in);
    public static void main( String[] args ) {
        menu();
        //Connection working
        /*MySqlCredentials msc = new MySqlCredentials();
        try (Connection conection = DriverManager.getConnection(msc.getConnectionUrl(), msc.getUsername(), msc.getPass())) {
            String statemnt = "INSERT INTO users VALUES(null,'Adam','Kowalski','96122145537','02-285','Warszawa','akowlaski@outlook.com')";
            Statement stmt = conection.createStatement();
            stmt.executeUpdate(statemnt);
            System.out.println("Row inserted!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }*/
    }
    public static void menu(){
        boolean flag = true;
        while(flag){
            System.out.println(
                    "Enter your choice:\n"+
                            "1 - register new user\t"+
                            "2 - delete user\t"+
                            "other - exit"
            );
            int choice = scan.nextInt();
            scan.nextLine();
            switch(choice){
                case 1:
                    registerUser();
                    break;
                case 2:
                    deleteUser();
                    break;
                default:
                    flag = false;
            }
        }
    }
    public static void registerUser(){
        RegisterUser register = new RegisterUser();
        register.register();
    }
    public static void deleteUser(){

    }
}
