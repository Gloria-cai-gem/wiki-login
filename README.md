# Wiki Administrator Login - BIT235 Assessment 2 Part A

**Name:** Cai Bowen
**Student ID:** S1580648

A Spring Boot MVC application with a custom split-screen design that
authenticates an administrator using a hard coded credential.

## Hard coded credential

- Username: `bowen`
- Password: `123`

## How to run

Requires JDK 21 and Maven.

```
mvn spring-boot:run
```

Then open http://localhost:8080/login in a browser.

## Notes

- Input is trimmed and null-safe in the service layer
- Logout link on the welcome page
- Custom split-screen UI with SVG status icons

## Layers

- `controller` - HTTP GET/POST handling and view selection
- `service` - input cleaning and authentication logic
- `repository` - hard coded credential (MySQL in Part B)
- `model` - form backing object
- `templates` - Thymeleaf login, welcome and error pages
