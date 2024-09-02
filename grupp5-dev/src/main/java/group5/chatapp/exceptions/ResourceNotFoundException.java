package group5.chatapp.exceptions;

/**
 * Custom exception thrown when a requested resource is not found.
 * Typically used for handling cases where an entity, such as a user or chat,
 * is requested by its ID but does not exist in the database.
 */
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Constructs a new ResourceNotFoundException with the specified detail message.
     *
     * @param message the detail message explaining why the exception was thrown.
     */
    public ResourceNotFoundException(String message) {
        super(message);
    }

    /**
     * Constructs a new ResourceNotFoundException with the specified detail message
     * and cause.
     *
     * @param message the detail message explaining why the exception was thrown.
     * @param cause the cause of the exception (a null value is permitted, and indicates
     *              that the cause is nonexistent or unknown).
     */
    public ResourceNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
