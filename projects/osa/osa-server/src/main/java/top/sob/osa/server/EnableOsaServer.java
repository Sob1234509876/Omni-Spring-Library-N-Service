package top.sob.osa.server;

import org.springframework.context.annotation.Import;
import top.sob.osa.server.bean.OsaServer;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(OsaServer.class)
public @interface EnableOsaServer {
}
