package group5.chatapp.repositories;

import group5.chatapp.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for accessing {@link User} data in MongoDB.
 * Provides methods to perform CRUD operations on the User collection.
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {

    /**
     * Checks if a user with the given ID exists in the database.
     *
     * @param id the unique identifier of the user.
     * @return true if the user exists, false otherwise.
     */
    boolean existsById(String id);

    /**
     * Finds a user by their email address.
     *
     * @param email the email address of the user.
     * @return an {@link Optional} containing the user if found, or empty if not.
     */
    Optional<Object> findByEmail(String email);

    Optional<Object> findByFullName(String fullName);
}
