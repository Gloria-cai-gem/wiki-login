/*
 * Name: Cai Bowen
 * Student ID: S1580648
 * BIT235 Assessment 2 - Part A
 */
package edu.melbournepolytechnic.wiki.controller;

import edu.melbournepolytechnic.wiki.model.LoginRequest;
import edu.melbournepolytechnic.wiki.service.AuthenticationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

// handles the web requests for the login pages
@Controller
public class LoginController {

    // service that does the actual check
    private AuthenticationService authService;

    // spring injects the service through this constructor
    public LoginController(AuthenticationService authService) {
        this.authService = authService;
    }

    // show the login page
    @GetMapping({"/", "/login"})
    public String showLogin(Model model) {
        // empty object so the form has something to bind to
        model.addAttribute("loginRequest", new LoginRequest());
        return "login";
    }

    // run when the form is submitted
    @PostMapping("/login")
    public String doLogin(@ModelAttribute LoginRequest loginRequest, Model model) {
        // ask the service if the details are correct
        boolean ok = authService.checkLogin(
                loginRequest.getUsername(), loginRequest.getPassword());

        if (ok) {
            // correct details, load welcome page
            model.addAttribute("username", loginRequest.getUsername().trim());
            return "welcome";
        }

        // wrong details, load error page with a message
        model.addAttribute("errorMessage", "Wrong username or password, please try again.");
        model.addAttribute("loginRequest", new LoginRequest());
        return "error";
    }
}
