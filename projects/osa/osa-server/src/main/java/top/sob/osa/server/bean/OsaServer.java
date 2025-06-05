package top.sob.osa.server.bean;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import top.sob.osa.server.configuration.OsaServerAutoConfiguration;
import top.sob.osp.plf.annotation.Plugin;

@Component
@SpringBootApplication
@Import(OsaServerAutoConfiguration.class)
@Plugin(name = "Osa-Server", version = "1.0a")
public class OsaServer {
}
