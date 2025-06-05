package top.sob.osa.server.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import top.sob.osa.server.dao.mongo.MongoCsrfTokenDao;
import top.sob.osa.server.dao.mongo.MongoCsrfTokenRepository;
import top.sob.osa.server.dao.mongo.MongoUserDao;
import top.sob.osa.server.service.DefaultUserInitializerService;
import top.sob.osa.server.service.MongoUserDetailsService;

@Configuration
@Import(OsaServerDaoConfiguration.class)
public class OsaServerSecurityConfiguration {

    @Bean
    public MongoUserDetailsService osaServerMongoUserDetailsService(MongoUserDao mongoUserDao) {
        return new MongoUserDetailsService(mongoUserDao);
    }

    @Bean
    public MongoCsrfTokenRepository osaServerMongoCsrfTokenRepository(MongoCsrfTokenDao mongoCsrfTokenDao) {
        return new MongoCsrfTokenRepository(mongoCsrfTokenDao);
    }

    @Bean
    public PasswordEncoder osaServerPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DefaultUserInitializerService osaServerDefaultUserInitializerService() {
        return new DefaultUserInitializerService();
    }

    @Bean
    public PersistentTokenRepository osaServerPersistentTokenRepository() {
        return new InMemoryTokenRepositoryImpl();
    }

}
