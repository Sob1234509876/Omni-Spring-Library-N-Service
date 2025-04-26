package top.sob.osq.lib.configuration;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import top.sob.osq.lib.runner.OsqInterfaceImplRunner;

@Data
@NoArgsConstructor
@Configuration
public class OsqLibConfiguration {
    @Bean
    public OsqInterfaceImplRunner osqInterfaceImplRunner(ApplicationContext applicationContext) {
        return new OsqInterfaceImplRunner(applicationContext);
    }
}
