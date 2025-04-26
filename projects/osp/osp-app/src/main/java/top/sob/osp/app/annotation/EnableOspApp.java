package top.sob.osp.app.annotation;

import org.springframework.context.annotation.Import;
import top.sob.osp.app.configuration.OspAppConfiguration;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(OspAppConfiguration.class)
public @interface EnableOspApp {
}
