/*
 * Name: Cai Bowen
 * Student ID: S1580648
 * BIT235 Assessment 2 - Part A
 */
package edu.melbournepolytechnic.wiki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// starts the whole spring boot app
@SpringBootApplication
public class WikiApplication {

    // java runs this first
    public static void main(String[] args) {
        // boot the server
        SpringApplication.run(WikiApplication.class, args);
    }
}
