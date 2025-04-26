package top.sob.osp.server.service;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import top.sob.osp.app.annotation.Plugin;

import java.util.Map;

@Data
@NoArgsConstructor
@RequiredArgsConstructor
@Service
public class OspServerService implements BeanFactoryAware {

    @NonNull
    BeanFactory beanFactory;

    @Nullable
    public Map<String, String> getPlugin(String pluginName) {
        try {
            var bean = beanFactory.getBean(pluginName);
            var a = bean.getClass().getAnnotation(Plugin.class);

            if (a == null)
                return null;

            return Map.of("name", a.name(), "version", a.version());
        } catch (Throwable e) {
            return null;
        }
    }
}
