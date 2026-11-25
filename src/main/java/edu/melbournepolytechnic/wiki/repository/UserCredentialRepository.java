/*
 * Name: Cai Bowen
 * Student ID: S1580648
 * BIT235 Assessment 2 - Part A
 */
package edu.melbournepolytechnic.wiki.repository;

import org.springframework.stereotype.Repository;

// stores the login details, part A does not use a database
@Repository
public class UserCredentialRepository {

    // hard coded username and password
    private String validUser = "bowen";
    private String validPass = "123";

    // check the input against the stored values
    public boolean match(String username, String password) {
        // both have to be correct
        return validUser.equals(username) && validPass.equals(password);
    }
}
