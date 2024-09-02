package group5.chatapp.service;

import group5.chatapp.dto.ChatDTO;
import group5.chatapp.dto.MessageDTO;
import group5.chatapp.models.Chat;
import group5.chatapp.models.Message;
import group5.chatapp.repositories.ChatRepository;
import group5.chatapp.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Service class responsible for handling chat-related operations,
 * including creating chats, sending messages, and managing participants.
 */
@Service
public class ChatService {

    @Autowired
    private ChatRepository chatRepository;

    @Autowired
    private MessageRepository messageRepository;

    /**
     * Retrieves all chats ordered by the most recent message timestamp.
     *
     * @return a list of ChatDTO objects representing the chats.
     */
    public List<ChatDTO> getAllChats() {
        return chatRepository.findAllByOrderByLastMessageTimeDesc().stream().map(chat -> {
            ChatDTO chatDTO = new ChatDTO();
            chatDTO.setName(chat.getName());
            chatDTO.setParticipants(chat.getParticipants());
            return chatDTO;
        }).collect(Collectors.toList());
    }


    public String startChat(ChatDTO chatDTO) {
    /**
     * Starts a new chat with the given chat ID or retrieves the existing chat.
     *
     * @param chatId the ID of the chat to start or retrieve.
     * @return the ID of the started or existing chat.
     */
    
        Chat chat = new Chat();
        chat.setName(chatDTO.getName());
        chat.setParticipants(chatDTO.getParticipants());
        chat.setCreatedAt(LocalDateTime.now());
        chat.setLastMessageTime(LocalDateTime.now());
        chatRepository.save(chat);
        return chat.getId();
    }

    /**
     * Sends a message to the specified chat.
     *
     * @param chatId the ID of the chat to send the message to.
     * @param content the content of the message to be sent.
     */
    public void sendMessage(String chatId, String content) {
        Optional<Chat> chatOptional = chatRepository.findById(chatId);
        if (chatOptional.isPresent()) {
            Chat chat = chatOptional.get();
            Message message = new Message();
            message.setContent(content);
            message.setSender("sender");  // Placeholder for sender, should be replaced with actual sender
            message.setTimestamp(LocalDateTime.now().toString());
            messageRepository.save(message);
            chat.getMessages().add(message);
            chat.setLastMessageTime(LocalDateTime.now());
            chatRepository.save(chat);
        }
    }

    /**
     * Adds a participant to the specified chat.
     *
     * @param chatId the ID of the chat.
     * @param userId the ID of the user to add as a participant.
     */
    public void addParticipant(String chatId, String userId) {
        Optional<Chat> chatOptional = chatRepository.findById(chatId);
        if (chatOptional.isPresent()) {
            Chat chat = chatOptional.get();
            chat.getParticipants().add(userId);
            chatRepository.save(chat);
        }
    }

    /**
     * Retrieves the messages in the specified chat.
     *
     * @param chatId the ID of the chat.
     * @return a list of MessageDTO objects representing the messages in the chat.
     */
    public List<MessageDTO> getMessagesByChatId(String chatId) {
        Optional<Chat> chatOptional = chatRepository.findById(chatId);
        if (chatOptional.isPresent()) {
            return chatOptional.get().getMessages().stream().map(message -> {
                MessageDTO messageDTO = new MessageDTO();
                messageDTO.setId(message.getId());
                messageDTO.setSender(message.getSender());
                messageDTO.setContent(message.getContent());
                messageDTO.setTimestamp(message.getTimestamp());
                return messageDTO;
            }).collect(Collectors.toList());
        }
        return null;
    }
}
