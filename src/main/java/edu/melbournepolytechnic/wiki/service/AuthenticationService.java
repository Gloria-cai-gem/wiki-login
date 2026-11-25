/*
 * Name: Cai Bowen
 * Student ID: S1580648
 * BIT235 Assessment 2 - Part A
 */
package edu.melbournepolytechnic.wiki.service;

import edu.melbournepolytechnic.wiki.repository.UserCredentialRepository;
import org.springframework.stereotype.Service;

// does the login check between controller and repository
@Service
public class AuthenticationService {

    // repository that holds the valid login
    private UserCredentialRepository repo;

    // spring injects the repository here
    public AuthenticationService(UserCredentialRepository repo) {
        this.repo = repo;
    }

    // clean the input then check it
    public boolean checkLogin(String username, String password) {
        // stop null values from breaking the comparison
        if (username == null || password == null) {
            return false;
        }
        // trim spaces and let the repository compare
        return repo.match(username.trim(), password.trim());
    }
}
