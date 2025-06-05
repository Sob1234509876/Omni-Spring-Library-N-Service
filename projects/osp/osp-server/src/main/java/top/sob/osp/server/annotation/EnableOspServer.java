package top.sob.osp.server.annotation;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import top.sob.osp.server.configuration.OspServerAutoConfiguration;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(OspServerAutoConfiguration.class)
@Documented
@SpringBootApplication
@Inherited
public @interface EnableOspServer {
}
