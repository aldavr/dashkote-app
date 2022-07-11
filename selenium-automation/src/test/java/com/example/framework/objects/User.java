package com.example.framework.objects;

/**
 * Data Object (POJO) class.
 * POJO stands for Plain Old Java Object.
 * POJOs are used for increasing the readability and re-usability of a program.
 */
public class User {

    private String username;
    private String password;
    private String email;

    // To create Getters & Setters first create private fields then select them
    // right click /Generate (Alt+Insert) then select the fields and hit OK.

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
