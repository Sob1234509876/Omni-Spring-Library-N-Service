package top.sob.osa.server.configuration;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import top.sob.osa.server.controller.OsaServerController;
import top.sob.osa.server.service.OsaServerService;

@Import({OsaServerSecurityChainConfiguration.class,
        OsaServerServiceConfiguration.class})
@AutoConfiguration
public class OsaServerAutoConfiguration {

    @Bean
    public OsaServerController osaServerController(OsaServerService osaServerService) {
        return new OsaServerController(osaServerService);
    }

}
