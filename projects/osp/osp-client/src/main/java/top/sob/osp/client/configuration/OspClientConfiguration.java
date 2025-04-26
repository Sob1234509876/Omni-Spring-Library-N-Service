package top.sob.osp.client.configuration;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;
import top.sob.osp.client.runner.ServerPluginMatchRunner;

@Data
@NoArgsConstructor
@Import({OspRestTemplateConfiguration.class, OspServerUrlConfiguration.class})
@Configuration
public class OspClientConfiguration {
    @Bean
    public ServerPluginMatchRunner serverPluginMatchRunner(RestTemplate restTemplate, ApplicationContext applicationContext, String serverUrl) {
        return new ServerPluginMatchRunner(restTemplate, applicationContext, serverUrl);
    }
}
