/*
 * Name: Cai Bowen
 * Student ID: S1580648
 * BIT235 Assessment 2 - Part A
 * Web controller for the sign-in flow.
 */
package edu.melbournepolytechnic.wiki.controller;

import edu.melbournepolytechnic.wiki.model.LoginRequest;
import edu.melbournepolytechnic.wiki.service.AuthenticationService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Controller that maps browser requests to the login, welcome and error views.
 */
@Controller
public class LoginController {

    // Session key used to store the number of failed attempts for a visitor.
    private static final String ATTEMPT_KEY = "failedAttempts";

    // Injected service that performs the authentication check.
    private final AuthenticationService authenticationService;

    /**
     * Constructor injection of the service.
     * @param authenticationService Spring-managed authentication bean
     */
    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    /**
     * Renders the sign-in page for the root and /login GET paths.
     * @param model holder for view attributes
     * @return the login template name
     */
    @GetMapping({"/", "/login"})
    public String displayForm(Model model) {
        // Expose a fresh backing object so the template can bind its inputs.
        model.addAttribute("loginRequest", new LoginRequest());
        return "login";
    }

    /**
     * Handles a submitted sign-in form.
     * @param loginRequest bound form values
     * @param model holder for view attributes
     * @param session per-visitor session storing the failed attempt count
     * @return welcome view on success, error view on failure
     */
    @PostMapping("/login")
    public String handleSubmit(@ModelAttribute LoginRequest loginRequest,
                               Model model, HttpSession session) {
        // Ask the service to verify the submitted username and password.
        boolean granted = authenticationService.login(
                loginRequest.getUsername(), loginRequest.getPassword());

        // Branch on the verification result.
        if (granted) {
            // Reset the failed counter once a valid credential is supplied.
            session.removeAttribute(ATTEMPT_KEY);
            // Pass the typed name to the welcome view.
            model.addAttribute("username", loginRequest.getUsername().trim());
            return "welcome";
        }

        // Read the current counter, treating a missing attribute as zero.
        Integer current = (Integer) session.getAttribute(ATTEMPT_KEY);
        int attempts = current == null ? 1 : current + 1;
        // Persist the updated counter for the next retry.
        session.setAttribute(ATTEMPT_KEY, attempts);

        // Provide the message, counter and a backing object needed by the error template.
        model.addAttribute("errorMessage", "The username or password is incorrect. Please verify and retry.");
        model.addAttribute("attempts", attempts);
        model.addAttribute("loginRequest", new LoginRequest());
        return "error";
    }
}
