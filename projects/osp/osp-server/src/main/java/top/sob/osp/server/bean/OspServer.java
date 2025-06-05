package top.sob.osp.server.bean;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import top.sob.osp.plf.annotation.Plugin;
import top.sob.osp.server.configuration.OspServerAutoConfiguration;

@Component
@Import(OspServerAutoConfiguration.class)
@SpringBootApplication
@Plugin(name = "Osp-Server", version = "1.0a")
public class OspServer {
}
