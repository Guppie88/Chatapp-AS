package group5.chatapp.controllers;

import group5.chatapp.dto.UserDTO;
import group5.chatapp.models.User;
import group5.chatapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * Controller responsible for handling user-related operations, such as
 * searching for users by their ID.
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * Endpoint to search for a user by their ID.
     *
     * @param userId the ID of the user to search for.
     * @return a UserDTO object containing the user's information.
     */
    @PostMapping("/{userId}")
    public UserDTO searchUser(@PathVariable String userId) {
        return userService.searchUserById(userId);  // Calls the service layer to fetch user details
    }
}
