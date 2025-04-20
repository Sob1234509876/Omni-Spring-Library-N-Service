package top.sob.osp.server;

import org.springframework.context.annotation.Import;
import top.sob.osp.server.configuration.OspConfiguration;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Inherited
@Documented
@Import(OspConfiguration.class)
public @interface EnableOspServer {
}
