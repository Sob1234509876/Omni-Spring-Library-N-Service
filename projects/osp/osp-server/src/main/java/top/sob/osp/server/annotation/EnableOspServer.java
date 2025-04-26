package top.sob.osp.server.annotation;

import org.springframework.context.annotation.Import;
import top.sob.osp.server.configuration.OspServerConfiguration;

import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(OspServerConfiguration.class)
@Documented
@Inherited
public @interface EnableOspServer {
}
