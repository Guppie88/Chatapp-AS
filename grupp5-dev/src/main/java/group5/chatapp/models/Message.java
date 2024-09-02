package group5.chatapp.models;

import lombok.Getter;

/**
 * Represents a message within a chat.
 */
@Getter
public class Message {
    private String id;         // Unique identifier for the message
    private String sender;     // ID or username of the message sender
    private String content;    // The content of the message
    private String timestamp;  // Timestamp when the message was sent

    // Getter and Setter methods

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
     * Sets the timestamp for the message.
     *
     * @param timestamp the timestamp when the message was sent.
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
