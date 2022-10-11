package org.example;

import java.util.Scanner;

public class App 
{
    private static final Scanner scan = new Scanner(System.in);
    public static void main( String[] args ) {
        menu();
    }
    public static void menu(){
        boolean flag = true;
        while(flag){
            System.out.println(
                    "Enter your choice:\n"+
                            "1 - register new user | "+
                            "2 - delete user | "+
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
        DeleteUser delete = new DeleteUser();
        delete.delete();
    }
}
