package group5.chatapp.dto;

import lombok.Getter;

/**
 * Data Transfer Object (DTO) representing a message in a chat.
 * Used to transfer message data between layers.
 */
@Getter
public class MessageDTO {
    private String id;        // Unique identifier for the message
    private String sender;    // ID or username of the sender
    private String content;   // Content of the message
    private String timestamp; // Timestamp of when the message was sent

    /**
     * Sets the message ID.
     *
     * @param id the unique identifier for the message.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Sets the sender of the message.
     *
     * @param sender the ID or username of the sender.
     */
    public void setSender(String sender) {
        this.sender = sender;
    }

    /**
     * Sets the content of the message.
     *
     * @param content the content of the message.
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * Sets the timestamp for when the message was sent.
     *
     * @param timestamp the timestamp of the message.
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
