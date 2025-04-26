package top.sob.osp.server.bean;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import top.sob.osp.app.annotation.Plugin;
import top.sob.osp.server.configuration.OspServerConfiguration;

@Component
@Import(OspServerConfiguration.class)
@SpringBootApplication
@Plugin(name = "Osp-Server", version = "1.0a")
public class OspServer {
}
