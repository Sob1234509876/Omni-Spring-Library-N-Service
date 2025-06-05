package top.sob.osa.server.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import top.sob.osa.server.dao.mongo.MongoCsrfTokenDao;
import top.sob.osa.server.dao.mongo.MongoUserDao;

@Configuration
public class OsaServerDaoConfiguration {
    @Bean
    public MongoUserDao osaServerMongoUserDao(MongoTemplate mongo) {
        return new MongoUserDao(mongo);
    }

    @Bean
    public MongoCsrfTokenDao osaServerMongoCsrfTokenDao(MongoTemplate mongo) {
        return new MongoCsrfTokenDao(mongo);
    }
}
