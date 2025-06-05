package top.sob.osa.client.annotation;

import org.springframework.context.annotation.Import;
import top.sob.osa.client.configuration.OsaClientAutoConfiguration;

import java.lang.annotation.*;

@Inherited
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Import(OsaClientAutoConfiguration.class)
public @interface EnableOsaClient {
}
