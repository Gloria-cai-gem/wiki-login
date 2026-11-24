/*
 * Name: Cai Bowen
 * Student ID: S1580648
 * BIT235 Assessment 2 - Part A
 * Business logic layer for authentication.
 */
package edu.melbournepolytechnic.wiki.service;

import edu.melbournepolytechnic.wiki.repository.UserCredentialRepository;
import org.springframework.stereotype.Service;

/**
 * Service component that normalises user input and delegates the
 * credential comparison to the repository layer.
 */
@Service
public class AuthenticationService {

    // Final reference injected once through the constructor.
    private final UserCredentialRepository credentialRepository;

    /**
     * Constructor-based dependency injection.
     * @param credentialRepository Spring-managed repository bean
     */
    public AuthenticationService(UserCredentialRepository credentialRepository) {
        this.credentialRepository = credentialRepository;
    }

    /**
     * Normalises and verifies the submitted credential.
     * @param rawName username typed into the form
     * @param rawSecret password typed into the form
     * @return true when the cleaned pair matches the stored credential
     */
    public boolean login(String rawName, String rawSecret) {
        // Trim surrounding spaces so accidental whitespace does not fail a valid login.
        String cleanName = rawName == null ? "" : rawName.trim();
        // Apply the same cleaning to the password.
        String cleanSecret = rawSecret == null ? "" : rawSecret.trim();
        // Forward the cleaned values to the repository for the final comparison.
        return credentialRepository.checkCredential(cleanName, cleanSecret);
    }
}
