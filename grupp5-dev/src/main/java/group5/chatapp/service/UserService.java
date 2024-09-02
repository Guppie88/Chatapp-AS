package group5.chatapp.service;

import group5.chatapp.dto.UserDTO;
import group5.chatapp.models.User;
import group5.chatapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service class responsible for handling user-related operations such as searching users by ID.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * Searches for a user by their ID.
     *
     * @param userId the ID of the user to search for.
     * @return the UserDTO containing the user's details, or null if the user is not found.
     */
    public UserDTO searchUserById(String userId) {
        if (userRepository.existsById(userId)) {
            Optional<User> userOptional = userRepository.findById(userId);
            if (userOptional.isPresent()) {
                User user = userOptional.get();
                UserDTO userDTO = new UserDTO();
                userDTO.setId(user.getId());
                userDTO.setUsername(user.getUsername());
                return userDTO;
            } else {
                return null;
            }
        } else {
            return null;  // User not found
        }
    }
}
