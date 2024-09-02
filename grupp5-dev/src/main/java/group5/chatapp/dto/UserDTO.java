package group5.chatapp.dto;

import lombok.Getter;

/**
 * Data Transfer Object (DTO) representing a user.
 * Used to transfer user data such as ID and username between layers.
 */
@Getter
public class UserDTO {
    private String id;        // Unique identifier for the user
    private String username;  // Username of the user

    /**
     * Sets the user ID.
     *
     * @param id the unique identifier for the user.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets the username for the user.
     *
     * @param username the username of the user.
     */
    public void setUsername(String username) {
        this.username = username;
    }
}
