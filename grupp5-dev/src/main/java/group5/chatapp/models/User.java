package group5.chatapp.models;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Represents a user in the application, implementing the {@link UserDetails} interface for security purposes.
 */
@Document(collection = "users")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

    @Id
    private String id;                           // Unique identifier for the user

    private String fullName;                     // Full name of the user
    private String email;                        // Email address of the user (used as the username)
    private String password;                     // Hashed password of the user
    private boolean enabled;                     // Whether the user account is enabled
    private boolean accountNonExpired;           // Whether the user account is expired
    private boolean credentialsNonExpired;       // Whether the user credentials are expired
    private boolean accountNonLocked;            // Whether the user account is locked
    private List<GrantedAuthority> authorities;  // List of authorities/roles assigned to the user

    /**
     * Returns the authorities granted to the user.
     *
     * @return a collection of granted authorities.
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    /**
     * Returns the username used to authenticate the user. In this case, it is the user's email address.
     *
     * @return the username (email) of the user.
     */
    @Override
    public String getUsername() {
        return email;
    }

    /**
     * Indicates whether the user's account has expired.
     *
     * @return true if the user's account is non-expired, false otherwise.
     */
    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    /**
     * Indicates whether the user is locked or unlocked.
     *
     * @return true if the user's account is non-locked, false otherwise.
     */
    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    /**
     * Indicates whether the user's credentials (password) have expired.
     *
     * @return true if the user's credentials are non-expired, false otherwise.
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    /**
     * Indicates whether the user is enabled or disabled.
     *
     * @return true if the user is enabled, false otherwise.
     */
    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
