/*
 * Name: Cai Bowen
 * Student ID: S1580648
 * BIT235 Assessment 2 - Part A
 * In-memory credential store (database layer arrives in Part B).
 */
package edu.melbournepolytechnic.wiki.repository;

import org.springframework.stereotype.Repository;

/**
 * Repository component that owns the single accepted administrator credential.
 * The values are hard coded because Part A explicitly excludes database access.
 */
@Repository
public class UserCredentialRepository {

    // Accepted login name: first name written in lower case.
    private final String acceptedName = "bowen";

    // Accepted secret as specified by the assessment brief.
    private final String acceptedSecret = "123";

    /**
     * Compares a submitted pair against the stored credential.
     * @param inputName username supplied by the service
     * @param inputSecret password supplied by the service
     * @return true only when both strings match; null inputs never match
     */
    public boolean checkCredential(String inputName, String inputSecret) {
        // Reject null values first so the later equals() calls cannot throw a NullPointerException.
        if (inputName == null || inputSecret == null) {
            return false;
        }
        // Compare content with the stored constants; constants call equals() to stay null-safe.
        return acceptedName.equals(inputName) && acceptedSecret.equals(inputSecret);
    }
}
