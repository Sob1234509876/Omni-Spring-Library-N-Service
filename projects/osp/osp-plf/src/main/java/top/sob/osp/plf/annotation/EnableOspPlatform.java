package top.sob.osp.plf.annotation;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import top.sob.osp.plf.configuration.OspPlatformAutoConfiguration;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootApplication
@Import(OspPlatformAutoConfiguration.class)
public @interface EnableOspPlatform {
}
