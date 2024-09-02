package group5.chatapp.controllers;

import group5.chatapp.dto.ChatDTO;
import group5.chatapp.dto.MessageDTO;
import group5.chatapp.models.Chat;
import group5.chatapp.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller responsible for handling chat-related endpoints, such as starting chats,
 * sending messages, and managing participants.
 */
@RestController
@RequestMapping("/api/chats")
public class ChatController {

    @Autowired
    private ChatService chatService;

    /**
     * Endpoint to get all chats.
     *
     * @return a list of ChatDTO objects containing information about all chats.
     */
    @GetMapping
    public List<ChatDTO> getAllChats() {
        return chatService.getAllChats();
    }

    /**
     * Endpoint to start a new chat.
     *
     * @param chatId the ID of the chat to start.
     * @return a success message indicating that the chat has started.
     */
    @PostMapping
    public String startChat(@RequestBody ChatDTO chatDTO) {
        // Step 1: Get the current user's username or details
        String currentUsername = getCurrentUserUsername();

        // Step 2: Add the current user to the participants
        List<String> participants = chatDTO.getParticipants();
        if (participants == null) {
            participants = new ArrayList<>();
        }
        if (!participants.contains(currentUsername)) {
            participants.add(currentUsername);
        }
        chatDTO.setParticipants(participants);

        // Step 3: Create the chat
        Chat chat = new Chat();
        chat.setName(chatDTO.getName());
        chat.setParticipants(participants);  // now includes the current user
        chat.setCreatedAt(LocalDateTime.now());
        chat.setLastMessageTime(LocalDateTime.now());

        return chatService.startChat(chatDTO);
    }

    private String getCurrentUserUsername() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            return ((UserDetails) principal).getUsername();
        } else {
            return principal.toString(); // For simplicity, assuming principal is username
        }
    }

    /**
     * Endpoint to send a message to a specific chat.
     *
     * @param id the ID of the chat.
     * @param message the message to send to the chat.
     * @return a success message indicating that the message was sent.
     */
    @PostMapping("/{id}")
    public String sendMessage(@PathVariable String id, @RequestParam String message) {
        chatService.sendMessage(id, message);
        return "Message sent to chat ID: " + id;
    }

    /**
     * Endpoint to add a participant to a chat.
     *
     * @param id the ID of the chat.
     * @param userId the ID of the user to be added as a participant.
     */
    @PutMapping("/{id}")
    public void addParticipantToChat(@PathVariable String id, @RequestParam String userId) {
        chatService.addParticipant(id, userId);
    }

    /**
     * Endpoint to get all messages in a specific chat.
     *
     * @param id the ID of the chat.
     * @return a list of MessageDTO objects representing the messages in the chat.
     */
    @GetMapping("/{id}")
    public List<MessageDTO> getMessagesByChatId(@PathVariable String id) {
        return chatService.getMessagesByChatId(id);
    }
}
