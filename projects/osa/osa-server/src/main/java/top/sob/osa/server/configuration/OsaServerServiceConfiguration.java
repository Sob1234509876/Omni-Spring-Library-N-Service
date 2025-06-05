package top.sob.osa.server.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import top.sob.osa.server.service.OsaServerService;
import top.sob.osa.server.service.UserInitializerService;
import top.sob.osl.lib.dao.AbstractCrudRepository;

@Configuration
@Import(OsaServerSecurityConfiguration.class)
public class OsaServerServiceConfiguration {

    @Bean
    public OsaServerService osaServerService(AbstractCrudRepository<UserDetails, String> userDao, PasswordEncoder passwordEncoder, UserInitializerService userInitializerService) {
        return new OsaServerService(passwordEncoder, userDao, userInitializerService);
    }

}
