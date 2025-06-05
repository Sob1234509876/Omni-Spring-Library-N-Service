package top.sob.osa.server.dao.mongo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;
import top.sob.osl.lib.dao.mongo.AbstractMongoCrudRepository;

@SuppressWarnings("unused")
@EqualsAndHashCode(callSuper = true)
@Repository
@Data
public class MongoUserDao extends AbstractMongoCrudRepository<UserDetails, String> {
    public MongoUserDao() {
    }

    public MongoUserDao(@NonNull MongoTemplate mongo) {
        super(mongo);
    }
}
