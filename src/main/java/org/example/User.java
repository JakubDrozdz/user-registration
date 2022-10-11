package org.example;

public class User {
    private String firstName;
    private String lastName;
    private String pesel;
    private String postalCode;
    private String city;
    private String email;

    public User() {}

    public User(String firstName, String lastName, String postalCode, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
        this.city = city;
    }

    public String getFirstName() {return firstName;}

    public void setFirstName(String firstName) {this.firstName = firstName;}

    public String getLastName() {return lastName;}

    public void setLastName(String lastName) {this.lastName = lastName;}

    public String getPesel() {return pesel;}

    public void setPesel(String pesel) {this.pesel = pesel;}

    public String getPostalCode() {return postalCode;}

    public void setPostalCode(String postalCode) {this.postalCode = postalCode;}

    public String getCity() {return city;}

    public void setCity(String city) {this.city = city;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}
}
