package group5.chatapp.controllers;

import group5.chatapp.dto.LoginUserDto;
import group5.chatapp.dto.RegisterUserDto;
import group5.chatapp.models.LoginResponse;
import group5.chatapp.models.User;
import group5.chatapp.service.AuthenticationService;
import group5.chatapp.service.JwtService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller responsible for handling authentication and user registration endpoints.
 */
@RequestMapping("/api")
@RestController
public class AuthenticationController {

    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    /**
     * Constructor to inject required services.
     *
     * @param jwtService              the service for handling JWT operations.
     * @param authenticationService   the service for handling authentication and registration.
     */
    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    /**
     * Endpoint to register a new user.
     *
     * @param registerUserDto the data transfer object containing user registration details.
     * @return ResponseEntity containing the registered user information.
     */
    @PostMapping("/user")
    public ResponseEntity<User> register(@RequestBody RegisterUserDto registerUserDto) {
        if (registerUserDto == null ||
                registerUserDto.getEmail() == null ||
                registerUserDto.getPassword() == null ||
                registerUserDto.getEmail().isEmpty() ||
                registerUserDto.getPassword().isEmpty()){
            return ResponseEntity.badRequest().build();
        }

        if (authenticationService.emailExists(registerUserDto.getEmail())) {
            return ResponseEntity.badRequest().build();
        }

        if (authenticationService.fullNameExists(registerUserDto.getFullName())){
            return ResponseEntity.badRequest().build();
        }



        User registredUser = authenticationService.signup(registerUserDto);
        return ResponseEntity.ok(registredUser);
    }

    /**
     * Endpoint to authenticate an existing user and generate a JWT token.
     *
     * @param loginUserDto the data transfer object containing user login details.
     * @return ResponseEntity containing the JWT token and its expiration time.
     */
    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);

        LoginResponse loginResponse = new LoginResponse(jwtToken, jwtService.getExpirationTime());

        return ResponseEntity.ok(loginResponse);
    }
}
