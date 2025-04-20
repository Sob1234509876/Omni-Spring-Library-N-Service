package top.sob.osp.lib;

import org.springframework.context.annotation.Import;
import top.sob.osp.lib.configuration.OspConfiguration;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Inherited
@Import(OspConfiguration.class)
public @interface EnableOspLibrary {
}
