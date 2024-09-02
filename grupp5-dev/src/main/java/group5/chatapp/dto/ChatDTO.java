package group5.chatapp.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Data Transfer Object (DTO) representing a chat.
 * Used to transfer chat data between layers.
 */
@Setter
@Getter
public class ChatDTO {

   private String name;
    private List<String> participants;  // Lägg till detta fält

}

