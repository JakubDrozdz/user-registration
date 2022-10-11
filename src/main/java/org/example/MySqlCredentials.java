package org.example;

public class MySqlCredentials {
    private final String username="users_admin";
    private final String pass="ZAQ!2wsx";
    private final String connectionUrl = "jdbc:mysql://localhost:3306/users?&useSSL=false";

    public String getUsername() {
        return username;
    }

    public String getPass() {
        return pass;
    }

    public String getConnectionUrl() {
        return connectionUrl;
    }
}
