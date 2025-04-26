package top.sob.osp.server.configuration;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import top.sob.osp.server.controller.OspServerController;
import top.sob.osp.server.service.OspServerService;

@Data
@NoArgsConstructor
@Import(OspServerServiceConfiguration.class)
@Configuration
public class OspServerConfiguration {

    @Bean
    public OspServerController ospServerController(OspServerService service) {
        return new OspServerController(service);
    }

}
