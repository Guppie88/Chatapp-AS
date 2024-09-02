package group5.chatapp.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Data Transfer Object (DTO) for user login information.
 * Used to encapsulate the email and password for authentication.
 */
@Data
@NoArgsConstructor
public class LoginUserDto {
    private String email;    // User's email address
    private String password; // User's password
}
