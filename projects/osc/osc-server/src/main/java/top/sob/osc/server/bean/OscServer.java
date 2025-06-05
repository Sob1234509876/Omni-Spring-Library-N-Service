package top.sob.osc.server.bean;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import top.sob.osc.server.configuration.OscServerConfiguration;
import top.sob.osp.plf.annotation.Plugin;

@Component
@SpringBootApplication
@Import(OscServerConfiguration.class)
@Plugin(name = "Osc-Server", version = "1.0a")
public class OscServer {
}
