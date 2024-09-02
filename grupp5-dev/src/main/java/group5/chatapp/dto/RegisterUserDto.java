package group5.chatapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for user registration information.
 * Used to encapsulate user details during registration.
 */
@Data
@NoArgsConstructor
public class RegisterUserDto {
    private String email;    // User's email address
    private String password; // User's password
    private String fullName; // User's full name
}
