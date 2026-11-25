/*
 * Name: Cai Bowen
 * Student ID: S1580648
 * BIT235 Assessment 2 - Part A
 */
package edu.melbournepolytechnic.wiki.model;

// this class just holds the username and password from the form
public class LoginRequest {

    // values from the two input boxes
    private String username;
    private String password;

    // empty constructor, spring needs this
    public LoginRequest() {
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
}
