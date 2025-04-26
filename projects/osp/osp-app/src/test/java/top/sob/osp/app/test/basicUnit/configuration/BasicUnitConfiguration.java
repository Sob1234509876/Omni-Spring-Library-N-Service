package top.sob.osp.app.test.basicUnit.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import top.sob.osp.app.configuration.OspAppConfiguration;

@Import(OspAppConfiguration.class)
@Configuration
public class BasicUnitConfiguration {
}
