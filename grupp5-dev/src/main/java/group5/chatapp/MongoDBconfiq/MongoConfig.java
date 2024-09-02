package group5.chatapp.MongoDBconfiq;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import com.mongodb.client.MongoClients;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * This class configures MongoDB by enabling repository scanning and
 * setting up a MongoTemplate bean.
 */
@Configuration
@EnableMongoRepositories(basePackages = "group5.chatapp.repositories")
public class MongoConfig {

    /**
     * Defines a MongoTemplate bean to interact with MongoDB.
     *
     * @return a MongoTemplate instance.
     */
    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(MongoClients.create(), "chatapp");
    }
}
