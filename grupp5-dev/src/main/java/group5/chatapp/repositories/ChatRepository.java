package group5.chatapp.repositories;

import group5.chatapp.models.Chat;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for accessing {@link Chat} data in MongoDB.
 * Provides methods to perform CRUD operations on the Chat collection.
 */
@Repository
public interface ChatRepository extends MongoRepository<Chat, String> {

    /**
     * Retrieves all chat records ordered by the time of the last message in descending order.
     *
     * @return a list of chats ordered by the most recent message time.
     */
    List<Chat> findAllByOrderByLastMessageTimeDesc();
}
