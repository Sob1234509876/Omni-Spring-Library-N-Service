package top.sob.osp.lib.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import top.sob.osp.lib.Plugin;

import java.lang.reflect.Method;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Service
public class OspMetaService implements BeanPostProcessor {

    static final Method GET_PLUGIN_METHOD;

    static {
        try {
            GET_PLUGIN_METHOD = OspMetaServlet.class.getMethod("getPlugin");
        } catch (NoSuchMethodException e) {
            throw new AssertionError("How?");
        }
    }

    RequestMappingHandlerMapping handlers;

    MultiValueMap<String, Plugin> pluginMapping = new LinkedMultiValueMap<>();

    @Override
    public Object postProcessAfterInitialization(@NonNull Object bean, @NonNull String beanName) throws BeansException {
        if (!(bean instanceof Plugin plugin)) return bean;

        var module = bean.getClass().getModule().getName();

        pluginMapping.add(module, plugin);
        var path = "/api" + module.replace('.', '/');
        var servlet = new OspMetaServlet(plugin);

        handlers.registerMapping(RequestMappingInfo.paths(path).build(), servlet, GET_PLUGIN_METHOD);

        return bean;
    }
}
