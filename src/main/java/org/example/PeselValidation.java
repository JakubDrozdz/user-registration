package org.example;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class PeselValidation {
    private Set<String> peselList;
    private MySqlCredentials msc;

    public PeselValidation() {
        peselList = new HashSet<>();
        msc = new MySqlCredentials();
        getPesels();
    }

    private void getPesels(){
        try (Connection conection = DriverManager.getConnection(msc.getConnectionUrl(), msc.getUsername(), msc.getPass())) {
            PreparedStatement statemnt = conection.prepareStatement("SELECT pesel FROM users");
            ResultSet rs = statemnt.executeQuery();
            while(rs.next()){
                peselList.add(rs.getString("pesel"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Set<String> getPeselList() {
        return peselList;
    }
}
