package top.sob.osp.client.configuration;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@NoArgsConstructor
@Configuration
public class OspServerUrlConfiguration {
    @Bean
    public String serverUrl() {
        return "http://localhost:8080";
    }
}
