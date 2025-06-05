package top.sob.osp.plf.test.basicUnit.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import top.sob.osp.plf.configuration.OspPlatformAutoConfiguration;

@Import(OspPlatformAutoConfiguration.class)
@Configuration
public class BasicUnitConfiguration {
}
