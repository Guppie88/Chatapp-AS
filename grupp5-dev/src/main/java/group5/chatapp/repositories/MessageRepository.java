package group5.chatapp.repositories;

import group5.chatapp.models.Message;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for accessing {@link Message} data in MongoDB.
 * Provides methods to perform CRUD operations on the Message collection.
 */
@Repository
public interface MessageRepository extends MongoRepository<Message, String> {
    // Standard MongoDB repository for Message entities
}
