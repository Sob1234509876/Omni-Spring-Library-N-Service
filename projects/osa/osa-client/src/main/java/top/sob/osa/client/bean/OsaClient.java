package top.sob.osa.client.bean;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Component;
import top.sob.osa.client.configuration.OsaClientAutoConfiguration;
import top.sob.osp.plf.annotation.Plugin;

@Component
@SpringBootApplication
@Plugin(name = "Osa-Client", version = "1.0a")
@Import(OsaClientAutoConfiguration.class)
public class OsaClient {
}
