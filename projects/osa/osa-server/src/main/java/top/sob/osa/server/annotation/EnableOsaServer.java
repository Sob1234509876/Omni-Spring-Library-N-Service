package top.sob.osa.server.annotation;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import top.sob.osa.server.configuration.OsaServerAutoConfiguration;

import java.lang.annotation.*;

@Inherited
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootApplication
@Import(OsaServerAutoConfiguration.class)
public @interface EnableOsaServer {
}
