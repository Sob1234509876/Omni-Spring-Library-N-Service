package top.sob.osa.server.dao.mongo;

import lombok.NonNull;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Repository;
import top.sob.osl.lib.dao.mongo.AbstractMongoCrudRepository;

@Repository
public class MongoCsrfTokenDao extends AbstractMongoCrudRepository<CsrfToken, String> {
    public MongoCsrfTokenDao() {
    }

    public MongoCsrfTokenDao(@NonNull MongoTemplate mongo) {
        super(mongo);
    }
}
