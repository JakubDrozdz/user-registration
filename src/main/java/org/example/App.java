package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class App 
{
    public static void main( String[] args ) {
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
}
