package group5.chatapp.configs;

import group5.chatapp.repositories.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * This class configures application-level beans such as the user details service,
 * password encoder, and authentication manager.
 */
@Configuration
public class ApplicationConfiguration {

    private final UserRepository userRepository;

    /**
     * Constructor to inject the UserRepository dependency.
     *
     * @param userRepository the UserRepository to be used for fetching user data.
     */
    public ApplicationConfiguration(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Defines a bean for UserDetailsService, which loads user-specific data.
     *
     * @return a UserDetailsService that fetches user details from the database.
     */
    @Bean
    UserDetailsService userDetailsService() {
        return username -> (UserDetails) userRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    /**
     * Defines a bean for password encoding using BCrypt.
     *
     * @return a BCryptPasswordEncoder used for encoding passwords.
     */
    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Defines a bean for the AuthenticationManager, which handles authentication.
     *
     * @param config the AuthenticationConfiguration.
     * @return an AuthenticationManager instance.
     * @throws Exception if any error occurs during authentication manager setup.
     */
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    /**
     * Defines a bean for AuthenticationProvider that integrates UserDetailsService
     * and password encoder.
     *
     * @return a DaoAuthenticationProvider instance.
     */
    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }
}
