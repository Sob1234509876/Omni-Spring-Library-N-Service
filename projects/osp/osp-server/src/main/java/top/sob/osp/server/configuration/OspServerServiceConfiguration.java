package top.sob.osp.server.configuration;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.sob.osp.server.service.OspServerService;

@Data
@NoArgsConstructor
@Configuration
public class OspServerServiceConfiguration {

    @Bean
    public OspServerService ospServerService() {
        return new OspServerService();
    }
}
