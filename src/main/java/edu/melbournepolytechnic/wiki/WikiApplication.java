/*
 * Name: Cai Bowen
 * Student ID: S1580648
 * BIT235 Assessment 2 - Part A
 * Wiki Administrator Login and User Authentication
 */
package edu.melbournepolytechnic.wiki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Entry point of the Wiki login web application.
 * The @SpringBootApplication annotation enables component scanning,
 * auto-configuration and Spring Boot's Java-based configuration.
 */
@SpringBootApplication
public class WikiApplication {

    /**
     * main() is the first method executed by the JVM.
     * @param args command line arguments passed to the application
     */
    public static void main(String[] args) {
        // SpringApplication.run() boots the embedded Tomcat server and the Spring container.
        SpringApplication.run(WikiApplication.class, args);
    }
}
