package group5.chatapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents the response after a successful login, containing the JWT token
 * and the token's expiration time.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    private String token;    // JWT token
    private long expiresIn;  // Expiration time of the token in milliseconds
}
