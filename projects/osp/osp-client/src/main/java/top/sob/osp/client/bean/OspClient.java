package top.sob.osp.client.bean;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import top.sob.osp.app.annotation.Plugin;
import top.sob.osp.app.configuration.OspAppConfiguration;

@Component
@Import(OspAppConfiguration.class)
@SpringBootApplication
@Plugin(name = "Osp-Client", version = "1.0a")
public class OspClient {
}
