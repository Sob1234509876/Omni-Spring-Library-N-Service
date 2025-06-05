package top.sob.osp.client.annotation;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import top.sob.osp.client.configuration.OspClientAutoConfiguration;

import java.lang.annotation.*;

@Documented
@Inherited
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@SpringBootApplication
@Import(OspClientAutoConfiguration.class)
public @interface EnableOspClient {
}
