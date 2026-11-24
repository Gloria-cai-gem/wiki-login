/*
 * Name: Cai Bowen
 * Student ID: S1580648
 * BIT235 Assessment 2 - Part A
 * Form backing object for the sign-in page.
 */
package edu.melbournepolytechnic.wiki.model;

/**
 * Holds the two values submitted by the login form.
 * Thymeleaf and Spring MVC bind the input fields onto this bean through setters.
 */
public class LoginRequest {

    // Name entered by the visitor; starts as null until the form is bound.
    private String username;

    // Secret entered by the visitor; starts as null until the form is bound.
    private String password;

    /**
     * Empty constructor: Spring instantiates the bean first and injects values afterwards.
     */
    public LoginRequest() {
    }

    /**
     * Reads the bound username.
     * @return submitted username, possibly null
     */
    public String getUsername() {
        return username;
    }

    /**
     * Stores the username coming from the "username" request parameter.
     * @param username raw form value
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Reads the bound password.
     * @return submitted password, possibly null
     */
    public String getPassword() {
        return password;
    }

    /**
     * Stores the password coming from the "password" request parameter.
     * @param password raw form value
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
