package top.sob.osp.lib.configuration;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import top.sob.osp.lib.service.OspMetaService;

@Configuration
public class OspConfiguration {
    public OspMetaService ospMetaService(ApplicationContext context) {
        var handlers = context.getBeansOfType(RequestMappingHandlerMapping.class);
        if (handlers.size() != 1)
            throw new AssertionError("Expected exactly one RequestMappingHandlerMapping in application context");

        var handler = handlers.values().iterator().next();
        var service = new OspMetaService();
        service.setHandlers(handler);

        return service;
    }
}
