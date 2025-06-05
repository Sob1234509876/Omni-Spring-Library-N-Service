package top.sob.osp.client.bean;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import top.sob.osp.plf.annotation.Plugin;
import top.sob.osp.plf.configuration.OspPlatformAutoConfiguration;

@Component
@Import(OspPlatformAutoConfiguration.class)
@SpringBootApplication
@Plugin(name = "Osp-Client", version = "1.0a")
public class OspClient {
}
